package com.coc.member.conf;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//事务管理
@EnableTransactionManagement
@MapperScan("com.coc.member.mapper")
public class MyBatisConfig {
    //逻辑删除插件
    @Bean
    public ISqlInjector iSqlInjector()
    {
        return new LogicSqlInjector();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor()
    {return new PaginationInterceptor();}
}
