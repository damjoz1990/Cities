package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CityRepoJpa extends JpaRepository<City,Integer> {
    @Query("SELECT c FROM City c WHERE CONCAT(c.name, ' ', c.country, ' ' , c.population) LIKE %?1%")
    public List<City> search(String keyword);

}
