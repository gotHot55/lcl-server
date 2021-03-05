package com.micro.lcl.sleb.config.sql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource  .DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/814:00
 */
//@Configuration
//@MapperScan(basePackages = "com.micro.lcl.sleb.repository.core",sqlSessionFactoryRef = "coreSqlSessionFactory")
public class CoreDatasourceConfig {
    @Bean(name = "coreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.core")
    public DataSource coreDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "coreSqlSessionFactory")
    public SqlSessionFactory coreSqlSessionFactory(@Qualifier("coreDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //xml位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/core/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "coreSqlSessionTemplate")
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "CoreTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("coreDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
