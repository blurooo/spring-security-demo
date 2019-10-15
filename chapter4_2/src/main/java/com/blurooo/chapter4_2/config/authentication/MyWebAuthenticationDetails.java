package com.blurooo.chapter4_2.config.authentication;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private String imageCode;

    private String savedImageCode;

    public String getImageCode() {
        return imageCode;
    }

    public String getSavedImageCode() {
        return savedImageCode;
    }

    // 补充用户提交的验证码和session保存的验证码
    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.imageCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        this.savedImageCode = (String) session.getAttribute("captcha");
        if (!StringUtils.isEmpty(this.savedImageCode)) {
            // 随手清除验证码，不管是失败还是成功，所以客户端应在登录失败时刷新验证码
            session.removeAttribute("captcha");
        }
    }

}
