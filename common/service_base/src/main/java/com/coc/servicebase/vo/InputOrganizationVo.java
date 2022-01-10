package com.coc.servicebase.vo;

import lombok.Data;

@Data
public class InputOrganizationVo {
    private String orgName,userId;

    public InputOrganizationVo() {
    }

    public InputOrganizationVo(String orgName, String userId) {
        this.orgName = orgName;
        this.userId = userId;
    }
}
