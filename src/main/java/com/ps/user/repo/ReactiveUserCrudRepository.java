package com.ps.user.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ps.user.model.APPUser;

public interface ReactiveUserCrudRepository extends ReactiveCrudRepository<APPUser, Integer>{

}
