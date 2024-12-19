package com.toocans.controller;

import com.toocans.filter.TimezoneContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class TimezoneController {

    @GetMapping("/get-time")
    public String getTime() {
        ZoneId zoneId = TimezoneContext.getTimezone(); // 获取当前请求的时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId); // 转换为对应时区的时间
        System.out.println("当前时区 (" + zoneId + ") 时间: " + zonedDateTime);
        return "当前时区:" + zoneId;
    }

    @PostMapping("/post-time")
    public String postTime() {
        ZoneId zoneId = TimezoneContext.getTimezone(); // 获取当前请求的时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId); // 转换为对应时区的时间
        System.out.println("当前时区 (" + zoneId + ") 时间: " + zonedDateTime);
        return "当前时区:" + zoneId;
    }
}

