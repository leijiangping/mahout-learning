package cn.chaohi.recommend.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 数据源配置
 * @author leijp
 *
 */
@Configuration
public class DataSourceConfig {
	
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource dataSource ) throws Exception {
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	//bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*Mapper.xml"));
        bean.setTypeAliasesPackage("cn.chaohi.recommend.entity");
        bean.setDataSource(dataSource);
        return bean;
    }

}
