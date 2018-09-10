package com.example.demo.MycustomBeanAndTools;

import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;
//默认url请求参数为 locale
public class MyLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Override
    protected Locale parseLocaleValue(String locale) {
        if(locale.equals("default"))
            return null;
        return super.parseLocaleValue(locale);
    }
}
