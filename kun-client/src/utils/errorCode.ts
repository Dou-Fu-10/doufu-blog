export enum ErrorCode {
    Unauthorized = 401,
    Forbidden = 403,
    NotFound = 404,
    Default = 1000
}

const ErrorMessage: Record<ErrorCode|number, string> = {
    [ErrorCode.Unauthorized]: '认证失败，无法访问系统资源',
    [ErrorCode.Forbidden]: '当前操作没有权限',
    [ErrorCode.NotFound]: '访问资源不存在',
    [ErrorCode.Default]: '系统未知错误，请反馈给管理员'
};

export default ErrorMessage;
