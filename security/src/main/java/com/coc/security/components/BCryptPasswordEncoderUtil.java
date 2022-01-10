package com.coc.security.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderUtil extends BCryptPasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return super.matches(rawPassword,encodedPassword);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoderUtil util=new BCryptPasswordEncoderUtil();
        System.out.println(util.encode("s_hl"));
        System.out.println(util.encode("s_hl"));
        System.out.println(util.encode("s_hl"));
    }

}
