package com.ps.user.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ps.user.dtos.UserDTO;
import com.ps.user.exception.APPSDataAccessException;

import com.ps.user.exception.AlreadyExistsException;
import com.ps.user.exception.GlobalException;
import com.ps.user.model.APPUser;
import com.ps.user.repo.ReactiveUserCrudRepository;
import com.ps.user.repo.ReactiveUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReactiveUserRepository userRepository;
	
	@Override
	public Mono<APPUser> createUser(final APPUser user) {
		
		Flux<APPUser> appUserFlux =userRepository.findUser(user);
		Mono<APPUser> appUser = userRepository.findUser(user)
				.collectList().flatMap(data->{
					log.info("Retrived  Data "+data);
					if(data.isEmpty()) {
						return userRepository.save(user);
					}else {
						 return Mono.error(new  AlreadyExistsException(HttpStatus.CONFLICT,"User already exist with same user name or mobile or email "));
					}
				});
		
			return appUser;
		
	}
	
	private Mono<APPUser> saveUser(APPUser user){
		
		return userRepository.save(user);
	}

	@Override
	public Mono<APPUser> updateUser(final APPUser user) {
		return  userRepository.update(user);
	}

	

	@Override
	public Flux<APPUser> geAllUser() {
	
       
		
		  Flux<APPUser> user = userRepository.findAll();
		
		 return user;
		 
	
	}

	
	
	@Override
	public Flux<APPUser> getUsersByCriteria() {
		
		return null;
	}

	@Override
	public Mono<APPUser> deleteUser(Integer id) {
		return userRepository.findById(id)
				.flatMap(user ->this.userRepository.delete(user).thenReturn(user) );
		
	
	}

	@Override
	public Flux<APPUser> findByUserName(final String userName) {
		
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public Mono<APPUser> findById(Integer id) {
		
		return userRepository.findById(id);
	}
	@Override
	public Flux<APPUser> findByEmail(final String email) {
		
		return userRepository.findByEmail(email);
	}
	
	private UserDTO  convert(APPUser user){
		UserDTO dto = new UserDTO();
       BeanUtils.copyProperties(user, dto);
       return dto;
	}
	@Override
	public Mono<Integer> deleteAll() {
		
		return userRepository.deleteAll();
	}
}
