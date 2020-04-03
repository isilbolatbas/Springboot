package com.example.repository;

import com.example.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface KullaniciRepository extends MongoRepository<Kullanici, String> {

}
