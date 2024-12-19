package com.toocans.config;

import com.toocans.filter.TimezoneFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TimezoneFilter> timezoneFilter() {
        FilterRegistrationBean<TimezoneFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TimezoneFilter());
        return registrationBean;
    }
}
