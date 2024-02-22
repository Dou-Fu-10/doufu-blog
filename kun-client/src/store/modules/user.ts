import {defineStore} from 'pinia'
import {getToken, removeToken, setToken} from '@/utils/auth'
import {getInfo, login, logout} from '@/api/login'
import defAva from '@/assets/images/profile.jpg'
import {ref} from 'vue';
import {User, UserInfo} from "@/types/user";
import {AxiosResponse} from "axios";

const useUserStore = defineStore('user', () => {

    let token = getToken();
    const id = ref('');
    const name = ref('');
    const avatar = ref('');

    // 登录
    const Login = (userInfo: UserInfo) => {
        return new Promise<void>((resolve, reject) => {
            login(userInfo).then((response: AxiosResponse<{ token: string }>) => {
                setToken(response.data.token)
                token = response.data.token
                resolve()
            }).catch(error => {
                reject(error)
            })
        })
    };

    // 获取用户信息
    const GetInfo = () => {
        return new Promise((resolve, reject) => {
            getInfo().then((response: AxiosResponse<User>) => {
                const user = response.data
                const userAvatar = (user.avatar == "" || user.avatar == null) ? defAva : import.meta.env.VITE_APP_BASE_API + user.avatar;
                id.value = user.userId
                name.value = user.userName
                avatar.value = userAvatar
                resolve(response)
            }).catch(error => {
                reject(error)
            })
        })
    };

    // 退出系统
    const Logout = () => {
        return new Promise<void>((resolve, reject) => {
            logout().then(() => {
                token = ''
                removeToken()
                resolve()
            }).catch(error => {
                reject(error)
            })
        })
    };
    return {
        token,
        id,
        name,
        avatar,
        Login,
        GetInfo,
        Logout
    };
})

export default useUserStore
