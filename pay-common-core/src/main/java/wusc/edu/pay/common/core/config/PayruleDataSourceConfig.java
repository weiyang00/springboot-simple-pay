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
@MapperScan(basePackages = PayruleDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "payruleSqlSessionFactory")
public class PayruleDataSourceConfig {

    // 精确到 mapper.account 目录，以便跟其他数据源隔离
    static final String PACKAGE = "wusc.edu.pay.core.payrule.dao";

    @Value("${payrule.datasource.url}")
    private String url;

    @Value("${payrule.datasource.username}")
    private String user;

    @Value("${payrule.datasource.password}")
    private String password;

    @Value("${datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "payruleDataSource")
    public DataSource payruleDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "payruleTransactionManager")
    public DataSourceTransactionManager payruleTransactionManager() {
        return new DataSourceTransactionManager(payruleDataSource());
    }

    @Bean(name = "payruleSqlSessionFactory")
    public SqlSessionFactory costSqlSessionFactory(@Qualifier("payruleDataSource") DataSource payruleDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(payruleDataSource);
        return sessionFactory.getObject();
    }
}