package com.blurooo.chapter4_1.config;

import com.blurooo.chapter4_1.authentication.SecurityAuthenticationFailureHandler;
import com.blurooo.chapter4_1.authentication.SecurityAuthenticationSuccessHandler;
import com.blurooo.chapter4_1.filter.VerificationCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureHandler(new SecurityAuthenticationFailureHandler())
                .successHandler(new SecurityAuthenticationSuccessHandler())
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf().disable();
        // 将过滤器添加在UsernamePasswordAuthenticationFilter之前
        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
