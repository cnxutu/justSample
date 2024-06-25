//package com.example.demo.common.config;
//
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//
///**
// * @author: xutu
// * @since: 2023/9/19 17:49
// */
//@Configuration
//@MapperScan(basePackages = "com.example.demo.dao", sqlSessionFactoryRef = "masterSqlSessionFactory")
//public class MybatisPlusConfig {
//    /**
//     * 注意，此处需要使用MybatisSqlSessionFactoryBean，不是SqlSessionFactoryBean，
//     * 否则，使用mybatis-plus的内置函数时就会报invalid bound statement (not found)异常
//     */
//    @Bean("masterSqlSessionFactory")
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
//        // 设置数据源
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
//        //mapper的xml文件位置
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        String locationPattern = "classpath*:/mapper/*.xml";
//        mybatisSqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
//        //对应数据库的entity位置
//        String typeAliasesPackage = "com.example.demo.dao";
//        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
//        return mybatisSqlSessionFactoryBean.getObject();
//    }
//}
