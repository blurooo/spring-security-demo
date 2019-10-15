package com.blurooo.chapter4_2.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class CaptchaConfig {

    @Bean
    public Producer captcha() {
        // 配置图形验证码的基本参数
        Properties properties = new Properties();
        // 图片宽度
        properties.setProperty("kaptcha.image.width", "150");
        // 图片长度
        properties.setProperty("kaptcha.image.height", "50");
        // 字符集
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789");
        // 字符长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        // 使用默认的图形验证码实现，当然也可以自定义实现
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
