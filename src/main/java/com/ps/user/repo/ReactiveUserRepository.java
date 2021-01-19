package com.ps.user.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.ReactiveDeleteOperation.ReactiveDelete;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Component;

import com.ps.user.model.APPUser;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveUserRepository {
	
	@Autowired
	private R2dbcEntityTemplate r2dbcEntityTemplate;
	
	     public Mono<APPUser> save(APPUser entity){
	    
	    	return  r2dbcEntityTemplate.insert(entity);
	    	
	     }
	 	public Mono<APPUser> update(APPUser user) {
			
			return r2dbcEntityTemplate.update(user);
		}
		

		public  Flux<APPUser> findAll() {
			return  r2dbcEntityTemplate.select(APPUser.class).all();
			
		}
		
		public  Flux<APPUser> findByEmail(String email) {
	
			  return  this.r2dbcEntityTemplate.select(APPUser.class)
		                .matching(Query.query(Criteria.where("email").is(email))).all();
		}
		public  Flux<APPUser> findByMobile(String mobile) {
			
			  return  this.r2dbcEntityTemplate.select(APPUser.class)
		                .matching(Query.query(Criteria.where("email").is(mobile))).all();
	
		}
		public  Flux<APPUser> findByUserName(String userName) {
			
			  return  this.r2dbcEntityTemplate.select(APPUser.class)
		                .matching(Query.query(Criteria.where("userName").is(userName))).all();
	
		}
	public Flux<APPUser> findUser(APPUser user) {
			
		  return  this.r2dbcEntityTemplate.select(APPUser.class)
	                .matching(Query.query(Criteria.where("mobile").is(user.getMobile())
	                		        		.or(Criteria.where("email").is(user.getEmail()))
	                		.or(Criteria.where("userName").is(user.getUserName())))).all();
		}
	
		public  Mono<APPUser> findById(Integer id) {
		   return this.r2dbcEntityTemplate.selectOne(
					  Query.query(Criteria.where("id").is(id)), APPUser.class);
		}
	  public  Mono<Void> delete(APPUser user){
	    	 return this.r2dbcEntityTemplate.delete(user).then();
	    }
	  public  Mono<Integer> deleteAll(){
	    	 return this.r2dbcEntityTemplate.delete(APPUser.class).all();
	    }




}
