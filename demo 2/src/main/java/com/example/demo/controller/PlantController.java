package com.example.demo.controller;

import com.example.demo.dto.PlantDTO;
import com.example.demo.entity.Plant;
import com.example.demo.entity.Views;
import com.example.demo.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

   @Autowired
   private PlantService plantService;

   @PostMapping
   public Plant save(@RequestBody Plant plant){
      return plantService.save(plant);
   }

   @GetMapping("/lessThan/{price}")
   public List<Plant> findByPriceLessThan(@PathVariable BigDecimal price){
      return plantService.findByPriceLessThan(price);
   }

   @GetMapping
   public List <Plant> findAll(){
      return plantService.findAll();
   }

   @GetMapping("/deliveryCompleted/{plantId}")
   public Boolean deliveryCompleted(Long plantId){
      return plantService.deliveryCompleted(plantId);
   }

   public PlantDTO getPlantDTO(String name){
      return convertPlantToPlantDTO(plantService.getPlantByName(name));
   }

   @JsonView(Views.Public.class)
   public Plant getFilteredPlant(String name){
      return plantService.getPlantByName(name);
   }

   private PlantDTO convertPlantToPlantDTO(Plant plant){
      PlantDTO plantDTO = new PlantDTO();
      BeanUtils.copyProperties(plant, plantDTO);
      return plantDTO;
   }
}