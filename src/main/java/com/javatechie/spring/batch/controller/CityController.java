package com.javatechie.spring.batch.controller;

import com.javatechie.spring.batch.entity.City;

import com.javatechie.spring.batch.repository.CityRepo;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }


  //  @GetMapping("/cityByName/{name}")
  //  ResponseEntity<City> getCityName(@PathVariable String keyword){
  //      List<City> cityList = Arrays.stream(cityService.listAll(keyword)
   //             .toArray()).map(saveCity(City cityService.getCityById(int id))
   // }

    @GetMapping("/cityById/{id}")
    ResponseEntity<City> getCityById(@PathVariable int id){
        return cityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<City> cityList = cityService.listAll(keyword);
        model.addAttribute("cityList", cityList);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
        City city = new City();
        model.addAttribute("city", city);

        return "new_city";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");

        City city = cityService.get(id);
        mav.addObject("city", city);

        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCity(@PathVariable(name = "id") int id) {
        cityService.delete(id);

        return "redirect:/";
    }
}
