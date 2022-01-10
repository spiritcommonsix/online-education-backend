package com.coc.security.configuration.auth;


import com.baomidou.mybatisplus.extension.api.R;
import com.coc.commonutils.ResultCode;
import com.coc.commonutils.ResultData;
import com.coc.servicebase.exception.MyServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败操作
 */
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

//        R<String> data = R.failed("登录失败:"+e.getMessage());
        this.WriteJSON(request, response, ResultData.error().code(ResultCode.ERROR_NEED_DEAL).message("登陆失败:"+e.getMessage()));
    }
}