package com.toocans.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.ZoneId;

@WebFilter("/*") // 拦截所有请求
public class TimezoneFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 获取 X-Timezone 请求头
        String timezone = httpRequest.getHeader("X-Timezone");

        ZoneId zoneId = getZoneIdOrDefault(timezone);

        // 将时区存储到 ThreadLocal 中
        TimezoneContext.setTimezone(zoneId);

        // 继续请求处理
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    /**
     * 获取有效的时区，如果无效则返回默认时区
     *
     * @param timezone 时区字符串
     * @return 返回有效的 ZoneId
     */
    private ZoneId getZoneIdOrDefault(String timezone) {
        try {
            // 尝试解析时区 ID
            return ZoneId.of(timezone);
        } catch (Exception e) {
            // 如果无效时区，则返回默认时区
            System.out.println("无效时区，使用默认时区: " + e.getMessage());
            return ZoneId.systemDefault();  // 返回系统默认时区
        }
    }
}
