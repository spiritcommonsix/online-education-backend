package com.coc.servicebase.vo;

import lombok.Data;

@Data
public class UpdateUserInfoVo {
    private String memberAvatar;
    private String memberMobile;
    private Integer memberSex;
    private String memberSign;
    private String memberId;
}
