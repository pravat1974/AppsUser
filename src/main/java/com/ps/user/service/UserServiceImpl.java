package com.ps.user.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.user.dtos.UserDTO;
import com.ps.user.model.APPUser;
import com.ps.user.repo.ReactiveUserCrudRepository;
import com.ps.user.repo.ReactiveUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private ReactiveUserRepository userRepository;
	//@Autowired
	//private ReactiveUserCrudRepository crudRepository;

	@Override
	public Mono<APPUser> createUser(final APPUser user) {
		try {

			return userRepository.save(user);
		
		} catch (Exception ex) {
			System.out.println("error is user is " + ex);
		}
		return null;
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
		//return crudRepository.findAll();
       
		
		  Flux<APPUser> user = userRepository.findAll();
		 System.out.println("APPUser"+user); 
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
		
		//.flatMap(userRepository::delete) ;
	}

	@Override
	public Mono<APPUser> findById(Integer id) {
		
		return userRepository.findById(id);
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
