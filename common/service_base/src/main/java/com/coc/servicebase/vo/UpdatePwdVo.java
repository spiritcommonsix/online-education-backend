package com.coc.servicebase.vo;

import lombok.Data;

@Data
public class UpdatePwdVo {
    private String userId,originPwd,newPwd;
}
