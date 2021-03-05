package com.micro.lcl.sleb.config.sql;

import com.alibaba.druid.pool.DruidDataSource;
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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/811:03
 */
@Configuration
@MapperScan(basePackages = "com.micro.lcl.sleb.repository.master",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getMasterDatasource() throws SQLException {
//        return DataSourceBuilder.create().build();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setFilters("stat");
        dataSource.setFilters("wall");
        dataSource.setFilters("config");
//        dataSource.addFilters("stat");
//        dataSource.addFilters("wall");
        return dataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //xml位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/master/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "masterSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "MasterTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
