package com.example.demo.service;

import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

   @Autowired
   PlantRepository plantRepository;

   public List <Plant> findAll() {
      return plantRepository.findAll();
   }

   public List<Plant> findByPriceLessThan(BigDecimal price){
      return plantRepository.findByPriceLessThan(price);
   }

   public Boolean deliveryCompleted(Long plantId){
      return plantRepository.deliveryCompleted(plantId);
   }
   public Plant save(Plant plant) {
      return plantRepository.save(plant);
   }
   public Plant getPlantByName(String name){
      return new Plant();
   }
}