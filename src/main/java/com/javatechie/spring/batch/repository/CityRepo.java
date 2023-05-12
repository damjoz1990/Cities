package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.City;
import org.springframework.data.repository.CrudRepository;


public interface CityRepo extends CrudRepository<City, Integer> {
}
