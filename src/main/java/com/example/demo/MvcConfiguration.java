package com.example.demo;

import com.example.demo.MycustomBean.LoginInterceptor;
import com.example.demo.MycustomBean.MyLocaleChangeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean
    LocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(new Locale(""));
        cookieLocaleResolver.setCookieMaxAge(7*24*60*60);
        cookieLocaleResolver.setCookieName("language");
        return cookieLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyLocaleChangeInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/album");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/album").setViewName("album");
        registry.addViewController("/te").setViewName("template");
        registry.addViewController("/mas").setViewName("/mas");
        registry.addViewController("/form").setViewName("/form");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/ss").addResourceLocations("");
    }
}
