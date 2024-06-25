//package com.example.demo.common.config;//package com.xzl.policy.common.config;
//
//import org.apache.shardingsphere.broadcast.api.config.BroadcastRuleConfiguration;
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableReferenceRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.audit.ShardingAuditStrategyConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.*;
//
///**
// * @author: xutu
// * @since: 2023/9/18 16:20
// */
//@Configuration
//public class ShardingDatabasesAndTablesConfigurationPrecise {
//
//
//    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.shardingsphere.datasource.ds0")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//
//    public DataSource getDataSource() throws SQLException {
//        return ShardingSphereDataSourceFactory.createDataSource(createDataSourceMap(), Arrays.asList(createShardingRuleConfiguration(), createBroadcastRuleConfiguration()), new Properties());
//    }
//
//    private ShardingRuleConfiguration createShardingRuleConfiguration() {
//        ShardingRuleConfiguration result = new ShardingRuleConfiguration();
//        result.getTables().add(getOrderTableRuleConfiguration());
//        result.getTables().add(getOrderItemTableRuleConfiguration());
//        result.getBindingTableGroups().add(new ShardingTableReferenceRuleConfiguration("foo", "t_order, t_order_item"));
//        result.setDefaultDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("user_id", "inline"));
//        result.setDefaultTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "standard_test_tbl"));
//        Properties props = new Properties();
//        props.setProperty("algorithm-expression", "demo_ds_${user_id % 2}");
//        result.getShardingAlgorithms().put("inline", new AlgorithmConfiguration("INLINE", props));
//        result.getShardingAlgorithms().put("standard_test_tbl", new AlgorithmConfiguration("STANDARD_TEST_TBL", new Properties()));
//        result.getKeyGenerators().put("snowflake", new AlgorithmConfiguration("SNOWFLAKE", new Properties()));
//        result.getAuditors().put("sharding_key_required_auditor", new AlgorithmConfiguration("DML_SHARDING_CONDITIONS", new Properties()));
//        return result;
//    }
//
//    private ShardingTableRuleConfiguration getOrderTableRuleConfiguration() {
//        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("t_order", "demo_ds_${0..1}.t_order_${[0, 1]}");
//        result.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_id", "snowflake"));
//        result.setAuditStrategy(new ShardingAuditStrategyConfiguration(Collections.singleton("sharding_key_required_auditor"), true));
//        return result;
//    }
//
//    private ShardingTableRuleConfiguration getOrderItemTableRuleConfiguration() {
//        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("t_order_item", "demo_ds_${0..1}.t_order_item_${[0, 1]}");
//        result.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_item_id", "snowflake"));
//        return result;
//    }
//
//    private Map<String, DataSource> createDataSourceMap() {
//        Map<String, DataSource> result = new HashMap<>();
//        result.put("ds0", primaryDataSource());
//        return result;
//    }
//
//    private BroadcastRuleConfiguration createBroadcastRuleConfiguration() {
//        return new BroadcastRuleConfiguration(Collections.singletonList("t_address"));
//    }
//}
