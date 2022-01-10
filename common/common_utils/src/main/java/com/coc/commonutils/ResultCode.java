package com.coc.commonutils;

public interface ResultCode {
    /*
    * 权限不足：30001
    * 登录信息过期：40001
    * 登录失败：20001
    * */
    public static final Integer
    SUCCESS = 0,//成功
    ERROR = 20001, //失败但前端无需后续处理
    ERROR_NEED_DEAL=30001,//失败，但前端还需要后续处理
    NEED_LOGIN=40001;//需要重新登录

}
