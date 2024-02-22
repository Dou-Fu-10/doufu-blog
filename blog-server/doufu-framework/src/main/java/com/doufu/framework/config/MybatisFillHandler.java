package com.doufu.framework.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author Dou-Fu-10
 * @date 2023-07-07
 * @Description MybatisPlus 自动更新处理器
 */
@Configuration
public class MybatisFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        // 获取时间
        Date currentTime = new Date();
        // 判断是否拥有 createTime
        if (metaObject.hasSetter("createTime")) {
            Class<?> clazz = metaObject.getSetterType("createTime");
            if (Long.class.getName().equals(clazz.getName())) {
                setFieldValByName("createTime", System.currentTimeMillis(), metaObject);
            } else {
                setFieldValByName("createTime", currentTime, metaObject);
            }
        }
        // 判断是否拥有 updateTime
        if (metaObject.hasSetter("updateTime")) {
            Class<?> clazz = metaObject.getSetterType("updateTime");
            if (Long.class.getName().equals(clazz.getName())) {
                setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
            } else {
                setFieldValByName("updateTime", currentTime, metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date currentTime = new Date();
        // 判断是否拥有 updateTime
        if (metaObject.hasSetter("updateTime")) {
            Class<?> clazz = metaObject.getSetterType("updateTime");
            if (Long.class.getName().equals(clazz.getName())) {
                setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
            } else {
                setFieldValByName("updateTime", currentTime, metaObject);
            }
        }
    }

    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MybatisFillHandler());
        return globalConfig;
    }
}
