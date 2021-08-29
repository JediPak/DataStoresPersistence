package com.example.demo.repository;

import com.example.demo.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository <Plant, Long> {

   //you can use Operators like And/Or, Lessthan/greaterthan, null/notnull
   //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
   // "5.1.3. Query Methods" section
   List <Plant> findByPriceLessThan(BigDecimal price);
   //you can return a primitive directly

   @Query("select p.delivery.completed from Plant p where p.id = :plantId")
   Boolean deliveryCompleted(Long plantId);

//   Boolean isDeliveryCompleted(Long plantId)

   //Save a new Plant and return its Id
   //Check if a plant has been delivered
   //Find a list of plants cheaper than a specified amount

   //Add a method that allows you to find out if a specific plant has been delivered. It should take a Long plantId and return a Boolean.

//   @Query("select d.completed from Plant p where :outfit member of h.outfits ")
//   Boolean isPlantDelivered(@Param("outfit") Outfit outfit){
//
//   }
}
