package com.ps.user.service;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ps.user.model.APPUser;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IUserService {
	
	public Mono<APPUser> createUser(APPUser user);
	public Mono<APPUser> updateUser(APPUser user);
	public Mono<Void> deleteUser(Integer id);
	public Flux<APPUser> geAllUser();
	public Mono<APPUser> getUser(Integer id);
	public Flux<APPUser> getUsersByCriteria();

}

/*
 * @Bean public ConnectionFactory connectionFactory() {
 * System.out.println("HOST :" +DBHOST +"PORT "+ DBPORT +" user name"+USERNAME
 * +" DBPASSWORD "+DBPASSWORD +" DATABASE "+DBDATABASE); return
 * ConnectionFactories.get( ConnectionFactoryOptions.builder() .option(DRIVER,
 * "postgresql") .option(HOST, DBHOST) .option(PORT, DBPORT) .option(USER,
 * USERNAME) .option(PASSWORD, DBPASSWORD) .option(DATABASE, DBDATABASE)
 * .option(MAX_SIZE, 10) .build()); }
 */