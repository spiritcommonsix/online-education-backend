package com.coc.member.entity.vo;

import com.coc.member.entity.SysUserTable;
import com.coc.member.utils.BCryptPasswordEncoderUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class RegisterVo {
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String passWord;

    @ApiModelProperty(value = "手机号")
    private String telNumber;


    public SysUserTable transferBean()
    {
        SysUserTable userTable=new SysUserTable();
        userTable.setUserName(this.userName);
        BCryptPasswordEncoderUtil encoderUtil=new BCryptPasswordEncoderUtil();
        userTable.setPassWord(encoderUtil.encode(this.passWord));
        return userTable;
    }
}
