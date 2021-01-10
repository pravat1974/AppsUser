package com.ps.user.config;

import java.time.Duration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;
import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;

@Configuration
@EnableR2dbcRepositories
public class PostgressDBConfig extends AbstractR2dbcConfiguration {

	@Value("${spring.r2dbc.url}")
	private String JDBCURL;
	@Value("${postgres.r2dbc.username}")
	private String USERNAME;
	@Value("${postgres.r2dbc.password}")
	private String DBPASSWORD;
	@Value("${postgres.r2dbc.dbport}")
	private int DBPORT;
	@Value("${postgres.r2dbc.dbhost}")
	private String DBHOST;
	@Value("${postgres.r2dbc.database}")
	private String DBDATABASE;


	@Bean
	public ConnectionFactory connectionFactory() {
	System.out.println("USERNAME "+USERNAME);
	System.out.println("DBPASSWORD "+DBPASSWORD);
	System.out.println("DBDATABASE "+DBDATABASE);

		ConnectionFactory connectionFactory = ConnectionFactories
				.get(ConnectionFactoryOptions
				.builder()
				.option(DRIVER, "pool")
				.option(PROTOCOL, "postgresql")
				.option(HOST, DBHOST)
				.option(PORT, DBPORT)
				.option(USER, USERNAME)
				.option(PASSWORD, DBPASSWORD)
				.option(DATABASE, DBDATABASE)
				.option(MAX_SIZE, 10)

				.build());
	

		ConnectionPoolConfiguration configuration = 
				ConnectionPoolConfiguration.builder(connectionFactory)
				.maxIdleTime(Duration.ofMinutes(30)).
				initialSize(1).
				maxSize(10)
				.maxCreateConnectionTime(Duration.ofSeconds(10))
				.validationQuery("select 1 from appuser")
				.build();
		       return new ConnectionPool(configuration);
	}

	@Bean
	public R2dbcEntityTemplate getReactiveTemplate() {
		return new R2dbcEntityTemplate(connectionFactory());
	}
	@Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory());
    }

}