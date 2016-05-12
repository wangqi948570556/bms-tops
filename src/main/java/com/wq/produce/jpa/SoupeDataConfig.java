package com.wq.produce.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ImportResource({"classpath:/applicationContext.xml"})
@EnableJpaRepositories(
        basePackages = {
                "com.wq.produce.repository.jpa",
                "com.wq.produce.*.produce.repository.jpa"
        }
)
public class SoupeDataConfig {

    @Value("${soupe.persistence.type}")
    private String type;
    @Value("${soupe.persistence.dialect}")
    private String dialect;
    @Value("${soupe.persistence.username}")
    private String defaultSchema;
    @Value("${soupe.persistence.showsql}")
    private boolean showsql;
    @Value("${soupe.persistence.generateDdl}")
    private boolean generateDdl;
    @Value("${soupe.persistence.entity.packages}")
    private String entityPackages;
    @Value("${soupe.persistence.cache.enabled}")
    private boolean cacheEnabled;

    @Bean(name = "entityManagerFactory")
    @Autowired
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(
            DataSource dataSource, JpaDialect jpaDialect) {
        LocalContainerEntityManagerFactoryBean
                localContainerEntityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setPersistenceUnitName("BMS");

        localContainerEntityManagerFactoryBean
                .setDataSource(dataSource);

        HibernateJpaVendorAdapter jpaVendorAdapter
                = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.valueOf(type));
        jpaVendorAdapter.setShowSql(showsql);
        jpaVendorAdapter.setGenerateDdl(generateDdl);

        jpaVendorAdapter.setDatabasePlatform(dialect);
        localContainerEntityManagerFactoryBean
                .setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean
                .setJpaDialect(jpaDialect);

        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.default_schema", defaultSchema);
        hibernateProperties.put("hibernate.cache.use_query_cache", cacheEnabled);
        hibernateProperties.put("hibernate.cache.use_second_level_cache", cacheEnabled);
        hibernateProperties.put(
                "hibernate.cache.region.factory_class",
                "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        hibernateProperties.put("hibernate.max_fetch_depth", 1);
        hibernateProperties.put("hibernate.default_batch_fetch_size", 8);
        hibernateProperties.put("hibernate.default_entity_mode", "pojo");
        hibernateProperties.put("hibernate.format_sql", false);
        hibernateProperties.put("hibernate.order_updates", true);
        hibernateProperties.put("hibernate.generate_statistics", true);
        hibernateProperties.put("hibernate.jdbc.batch_versioned_data", true);
        hibernateProperties.put("hibernate.jdbc.use_get_generated_keys", true);
        hibernateProperties.put("hibernate.flush_before_completion", true);
        hibernateProperties.put("hibernate.query.jpaql_strict_compliance", true);
        hibernateProperties.put("hibernate.jdbc.batch_size", 200);
        hibernateProperties.put("hibernate.search.lucene_version", "LUCENE_36");

        localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties);

        List<String> packages = new ArrayList<String>();
        packages.addAll(Arrays.asList(entityPackages.trim().split(",")));

        localContainerEntityManagerFactoryBean
                .setPackagesToScan(packages.toArray(new String[packages.size()]));

        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    @Autowired
    public PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean(name = "jpaDialect")
    public JpaDialect getJpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean(name = "jdbcTemplate")
    @Autowired
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

}
