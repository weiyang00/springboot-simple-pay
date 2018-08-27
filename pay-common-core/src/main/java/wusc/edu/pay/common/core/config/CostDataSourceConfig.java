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
@MapperScan(basePackages = CostDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "costSqlSessionFactory")
public class CostDataSourceConfig {

    // 精确到 mapper.account 目录，以便跟其他数据源隔离
    static final String PACKAGE = "wusc.edu.pay.core.cost.dao";

    @Value("${cost.datasource.url}")
    private String url;

    @Value("${cost.datasource.username}")
    private String user;

    @Value("${cost.datasource.password}")
    private String password;

    @Value("${datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "costDataSource")
    public DataSource costDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "costTransactionManager")
    public DataSourceTransactionManager costTransactionManager() {
        return new DataSourceTransactionManager(costDataSource());
    }

    @Bean(name = "costSqlSessionFactory")
    public SqlSessionFactory costSqlSessionFactory(@Qualifier("costDataSource") DataSource accountDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(accountDataSource);
        return sessionFactory.getObject();
    }
}