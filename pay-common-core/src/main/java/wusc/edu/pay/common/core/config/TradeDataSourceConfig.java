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
@MapperScan(basePackages = TradeDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "tradeSqlSessionFactory")
public class TradeDataSourceConfig {

    // 精确到 mapper.account 目录，以便跟其他数据源隔离
    static final String PACKAGE = "wusc.edu.pay.core.trade.dao";

    @Value("${trade.datasource.url}")
    private String url;

    @Value("${trade.datasource.username}")
    private String user;

    @Value("${trade.datasource.password}")
    private String password;

    @Value("${datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "tradeDataSource")
    public DataSource tradeDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "tradeTransactionManager")
    public DataSourceTransactionManager tradeTransactionManager() {
        return new DataSourceTransactionManager(tradeDataSource());
    }

    @Bean(name = "tradeSqlSessionFactory")
    public SqlSessionFactory costSqlSessionFactory(@Qualifier("tradeDataSource") DataSource tradeDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(tradeDataSource);
        return sessionFactory.getObject();
    }
}