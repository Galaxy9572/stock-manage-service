package com.jy.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liaojunyao
 */
@EnableAsync
@EnableTransactionManagement
@EnableAspectJAutoProxy
@SpringBootApplication
public class StockManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockManageServiceApplication.class, args);
    }

}
