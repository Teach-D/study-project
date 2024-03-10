package com.study.project.spring.mvc2;

import com.study.project.spring.mvc2.typeconverter.formatter.MyNumberFormatter;
import com.study.project.spring.mvc2.login.filter.LogFilter;
import com.study.project.spring.mvc2.login.filter.LoginCheckFilter;
import com.study.project.spring.mvc2.login.resolver.MyHandlerExceptionResolver;
import com.study.project.spring.mvc2.login.resolver.UserHandlerExceptionResolver;
import com.study.project.spring.mvc2.typeconverter.converter.IpPortToStringConverter;
import com.study.project.spring.mvc2.typeconverter.converter.StringToIntegerConverter;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /* @Override
   public void addArgumentResolvers(List<HandlerMethodArgumentResolver>
                                             resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }*/

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new MyHandlerExceptionResolver());
        resolvers.add(new UserHandlerExceptionResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/error", "/error-page/**");*/

        /*registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/guPage/index", "/login", "/logout", "/css/*", "/", "/members/add", "/board/list"
                );*/
    }

    //@Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new
                FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR, DispatcherType.REQUEST);
        return filterRegistrationBean;
    }

    //@Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new
                FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
       /* registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());*/
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIntegerConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
