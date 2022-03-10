package com.ggori.dms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(
    value="com.ggori.dms",
    excludeFilters = {
        @Filter(type = FilterType.REGEX, pattern = "com.ggori.dms.web.*")
    })
@EnableAsync
@EnableScheduling
public class RootConfig {

}
