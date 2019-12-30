package com.felixso_infotech.config;

import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.felixso_infotech.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

	private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

	@Value("${spring.data.neo4j.uri}")
	private String databaseUrl;

	@Value("${spring.data.neo4j.username}")
	private String userName;

	@Value("${spring.data.neo4j.password}")
	private String password;

	@Bean
	public SessionFactory sessionFactory() {
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
				.uri(databaseUrl).credentials(userName, password).build();
		// with domain entity base package(s)
		return new SessionFactory(configuration,"com.felixso_infotech.domain");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

}