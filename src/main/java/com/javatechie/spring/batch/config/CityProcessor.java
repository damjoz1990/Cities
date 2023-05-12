package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.City;
import org.springframework.batch.item.ItemProcessor;

public class CityProcessor implements ItemProcessor<City,City> {

    @Override
    public City process(City city) throws Exception {
            return city;
    }
}
