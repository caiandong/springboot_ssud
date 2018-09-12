package com.example.demo;

import com.example.demo.MycustomBeanAndTools.LoginInterceptor;
import com.example.demo.MycustomBeanAndTools.MyLocaleChangeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties({Serverproperties.class})
public class MvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private Serverproperties serverproperties;
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
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/houtai");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("shouye1");
        registry.addViewController("/album").setViewName("album");
        registry.addViewController("/te").setViewName("template");
        registry.addViewController("/mas").setViewName("mas");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/shouye").setViewName("shouye");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images").addResourceLocations(serverproperties.getXuniduankou());
    }
}
