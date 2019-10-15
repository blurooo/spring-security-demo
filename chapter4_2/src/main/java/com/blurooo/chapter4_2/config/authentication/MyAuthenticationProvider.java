package com.blurooo.chapter4_2.config.authentication;

import com.blurooo.chapter4_2.exception.VerificationCodeException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    // 构造方法注入UserDetailService和PasswordEncoder
    public MyAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.setUserDetailsService(userDetailsService);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) usernamePasswordAuthenticationToken.getDetails();
        String imageCode = details.getImageCode();
        String savedImageCode = details.getSavedImageCode();
        // 检验图形验证码
        if (StringUtils.isEmpty(imageCode) || StringUtils.isEmpty(savedImageCode) || !imageCode.equals(savedImageCode)) {
            throw new VerificationCodeException();
        }
        super.additionalAuthenticationChecks(userDetails, usernamePasswordAuthenticationToken);
    }

}
