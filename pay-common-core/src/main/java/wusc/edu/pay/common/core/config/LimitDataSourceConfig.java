package wusc.edu.pay.common.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 mapper 接口并容器管理
@MapperScan(basePackages = LimitDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "limitSqlSessionFactory")
public class LimitDataSourceConfig {

    // 精确到 mapper.account 目录，以便跟其他数据源隔离
    static final String PACKAGE = "wusc.edu.pay.core.limit.dao";

    @Value("${limit.datasource.url}")
    private String url;

    @Value("${limit.datasource.username}")
    private String user;

    @Value("${limit.datasource.password}")
    private String password;

    @Value("${datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "limitDataSource")
    public DataSource limitDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "limitTransactionManager")
    public DataSourceTransactionManager limitTransactionManager() {
        return new DataSourceTransactionManager(limitDataSource());
    }

    @Bean(name = "limitSqlSessionFactory")
    public SqlSessionFactory bossSqlSessionFactory(@Qualifier("limitDataSource") DataSource limitDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(limitDataSource);
        return sessionFactory.getObject();
    }
}