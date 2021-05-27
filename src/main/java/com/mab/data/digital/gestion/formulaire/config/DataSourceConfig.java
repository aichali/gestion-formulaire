package com.mab.data.digital.gestion.formulaire.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("com.mab.data.digital.gestion.formulaire.domain")
@EnableJpaRepositories("com.mab.data.digital.gestion.formulaire.repository")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    private static final int TRANSACTION_TIMEOUT = 60 * 2; // 2min

    @Bean
    @Primary
    public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	dataSource.setUrl(env.getProperty("spring.datasource.url"));
	dataSource.setUsername(env.getProperty("spring.datasource.username"));
	dataSource.setPassword(env.getProperty("spring.datasource.password"));
	return dataSource;
    }

    @Autowired
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	// Data Source
	em.setDataSource(dataSource);
	// Scan du package des Beans ORM
	em.setPackagesToScan("com.mab.data.digital.gestion.formulaire.domain");
	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	em.setJpaVendorAdapter(vendorAdapter);
	em.setJpaProperties(additionalProperties());
	return em;
    }

    private Properties additionalProperties() {
	Map<String, Object> hibernateProps = new LinkedHashMap<>();
	hibernateProps.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
	hibernateProps.put("spring.jpa.hibernate.naming-strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
	hibernateProps.put(AvailableSettings.SHOW_SQL, "true");
	hibernateProps.put(AvailableSettings.FORMAT_SQL, "true");
	hibernateProps.put(AvailableSettings.USE_SQL_COMMENTS, "true");
	hibernateProps.put(AvailableSettings.GENERATE_STATISTICS, "false");
	Properties prop = new Properties();
	prop.putAll(hibernateProps);
	return prop;
    }

    @Autowired
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setDefaultTimeout(TRANSACTION_TIMEOUT);
	transactionManager.setEntityManagerFactory(emf);
	return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
    }
}