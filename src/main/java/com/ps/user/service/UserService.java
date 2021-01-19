package com.ps.user.service;


import com.ps.user.model.APPUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {
	
	public Mono<APPUser> createUser(APPUser user);
	public Mono<APPUser> updateUser(APPUser user);
	public Mono<APPUser> deleteUser(Integer id);
	public Flux<APPUser> geAllUser();
	public Mono<APPUser> findById(Integer id);
	public Flux<APPUser> getUsersByCriteria();
	public Mono<Integer> deleteAll();
	public Flux<APPUser> findByEmail(String email);
	Flux<APPUser> findByUserName(String userName);

}

