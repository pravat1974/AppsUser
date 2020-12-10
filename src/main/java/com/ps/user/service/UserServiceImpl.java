package com.ps.user.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.user.dtos.UserDTO;
import com.ps.user.model.APPUser;

import com.ps.user.repo.ReactiveUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private ReactiveUserRepository userRepository;

	@Override
	public Mono<APPUser> createUser(final APPUser user) {
		try {
//			Mono<APPUser> newUser = userRepository.findByEmail(user.getEmail())
//					.switchIfEmpty(saveUser(user));
	return userRepository.save(user);
		
		} catch (Exception ex) {
			System.out.println("error is user is " + ex);
		}
		return null;
	}
	
	private Mono<APPUser> saveUser(APPUser user){
		System.out.println(" user is " + user);
		return userRepository.save(user);
	}

	@Override
	public Mono<APPUser> updateUser(final APPUser user) {
		return null;
//		return userRepository.findById(user.getId()).flatMap(updatedUser -> {
//			LocalDateTime time = LocalDateTime.now();
//			updatedUser.setCreatedTime(time);
//			updatedUser.setLastUpdatedTime(time);
//			BeanUtils.copyProperties(user, updatedUser);
//
//			return this.userRepository.save(updatedUser);
//
//		});
	}

	

	@Override
	public Flux<APPUser> geAllUser() {

		return userRepository.findAll();
	
	}

	
	
	@Override
	public Flux<APPUser> getUsersByCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteUser(Integer id) {
		return userRepository.findById(id).flatMap(userRepository::delete) ;
	}

	@Override
	public Mono<APPUser> getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private UserDTO  convert(APPUser user){
		UserDTO dto = new UserDTO();
       BeanUtils.copyProperties(user, dto);
       return dto;
	}

}
