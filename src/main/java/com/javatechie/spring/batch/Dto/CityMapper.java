package com.javatechie.spring.batch.Dto;

import com.javatechie.spring.batch.entity.City;
import org.springframework.stereotype.Service;

@Service
public class CityMapper {
    City map(CityDto dto){
        City city = new City();
        city.setId(dto.getId());
        city.setName(dto.getName());
        city.setCountry(dto.getCountry());
        city.setPopulation(dto.getPopulation());
        return city;
    }
}
