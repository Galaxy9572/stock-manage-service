package com.jy.stock.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.mongo.JacksonMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

/**
 * Http Session 配置
 * @author liaojunyao
 */
@Configuration
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 3600)
public class HttpSessionConfig {

    @Bean
    public JacksonMongoSessionConverter jacksonMongoSessionConverter() {
        return new JacksonMongoSessionConverter();
    }

}
