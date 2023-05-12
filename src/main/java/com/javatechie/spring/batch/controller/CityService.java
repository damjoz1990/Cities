package com.javatechie.spring.batch.controller;

import com.javatechie.spring.batch.Dto.CityDto;
import com.javatechie.spring.batch.Dto.CityMapper;
import com.javatechie.spring.batch.entity.City;
import com.javatechie.spring.batch.repository.CityRepo;
import com.javatechie.spring.batch.repository.CityRepoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepoJpa cityRepoJpa;

    public CityService(CityRepo cityRepo, CityMapper cityMapper, CityRepoJpa cityRepoJpa) {
        this.cityRepo = cityRepo;
        this.cityMapper = cityMapper;
        this.cityRepoJpa = cityRepoJpa;
    }

    Optional<City> getCityById(int id){
        return cityRepo.findById(id);
    }

    public List<City> listAll(String keyword) {
        if (keyword != null) {
            return cityRepoJpa.search(keyword);
        }
        return cityRepoJpa.findAll();
    }

    public void save(City city) {
        cityRepoJpa.save(city);
    }

    public City get(int id) {
        return cityRepoJpa.findById(id).get();
    }

    public void delete(int id) {
        cityRepoJpa.deleteById(id);
    }
}
