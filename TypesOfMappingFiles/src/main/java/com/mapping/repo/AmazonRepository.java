package com.mapping.repo;

import org.springframework.data.repository.CrudRepository;

import com.mapping.entites.AmazonAccount;

public interface AmazonRepository extends CrudRepository<AmazonAccount, Integer>{

}
