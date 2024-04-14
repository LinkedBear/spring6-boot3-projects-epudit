package com.linkedbear.springboot.webmvc.c_requestparam.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    
    @Override
    public Date convert(String source) {
        if (StringUtils.hasText(source)) {
            LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-DD"));
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            return Date.from(zonedDateTime.toInstant());
        }
        return null;
    }
}
