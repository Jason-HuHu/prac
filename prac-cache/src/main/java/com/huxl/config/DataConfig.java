package com.huxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataConfig implements TransactionManagementConfigurer {
    //通过javaConfig显式配置Spring
    @Bean
    @Primary
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.H2);
        builder.addScript("classpath:db/jdbc/schema.sql");
        builder.addScript("classpath:db/jdbc/test-data.sql");
        return builder.build();
    }

    /**
     * @Bean注解会告诉Spring该方法将返回一个对象，
     * @该对象要注册为Spring应用上下文中的bean，方法体中包含了最终产生bean实例的逻辑
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
