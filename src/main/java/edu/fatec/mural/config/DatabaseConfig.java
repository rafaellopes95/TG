package edu.fatec.mural.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("edu.fatec.mural.dao")	//buscar as daos e assim injetar o EntityManager
public class DatabaseConfig {

	/*
	 * PersistenceAnnotationBeanPostProcessor
	 * Sua funcao eh justamente procurar por annotations @PersistenceContext e @PersistenceUnit p/
	 * fazer a injecao do EntityManager nas DAOs
	 */
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor = new PersistenceAnnotationBeanPostProcessor();
		
		return persistenceAnnotationBeanPostProcessor;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521");
		dataSource.setUsername("rafael");
		dataSource.setPassword("123");
		System.out.println("DataSource criado");
		return dataSource;
	}
	
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        jpaVendorAdapter.setGenerateDdl(true);
        
        System.out.println("JpaVendorAdapter criado");
        return jpaVendorAdapter;
    }  
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactory.setBeanName("entityManagerFactory");
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory.setPersistenceUnitName("muralPersistenceUnit");
		entityManagerFactory.setPackagesToScan("edu.fatec.mural.model");
		
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		entityManagerFactory.setLoadTimeWeaver(loadTimeWeaver);
		
		System.out.println("EntityManagerFactory criado, ");
		System.out.println("DataSource: " + entityManagerFactory.getDataSource() + "\n"
				+ "JpaVendorAdapter: " + entityManagerFactory.getJpaVendorAdapter());
		
		return entityManagerFactory;
	}
}
