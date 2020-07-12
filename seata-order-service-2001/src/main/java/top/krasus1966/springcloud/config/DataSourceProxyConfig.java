package top.krasus1966.springcloud.config;

/**
 * @author Krasus1966
 * @date 2020/7/9 22:11
 **/
//@Configuration
//public class DataSourceProxyConfig {
//
//    @Value("${mybatis-plus.mapper-locations}")
//    private String mapperLocations;
//
//    @Primary
//    @Bean("dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//
//    @Bean
//    public DataSourceProxy dataSourceProxy(DataSource  dataSource){
//        return new DataSourceProxy(dataSource);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//        return sqlSessionFactoryBean.getObject();
//    }
//}
