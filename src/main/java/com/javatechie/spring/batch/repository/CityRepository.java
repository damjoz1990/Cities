package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {

}
