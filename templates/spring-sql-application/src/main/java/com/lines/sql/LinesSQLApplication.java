package com.lines.sql;

import com.lines.sql.db.MyRoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class LinesSQLApplication {
    public static void main(String[] args) {
        SpringApplication.run(LinesSQLApplication.class, args);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        MyRoutingDataSource replicationRoutingDataSource = new MyRoutingDataSource();

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@***.***.**.***:****:*****");
        dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
        dataSource.setUsername("*********");
        dataSource.setPassword("*********");

        Map<Object, Object> dataSourceMap = new LinkedHashMap<>();
        dataSourceMap.put("LINES", dataSource);
        replicationRoutingDataSource.setTargetDataSources(dataSourceMap);
        replicationRoutingDataSource.setDefaultTargetDataSource(dataSource);

        return replicationRoutingDataSource;
    }
}
