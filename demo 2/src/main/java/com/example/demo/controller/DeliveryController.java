package com.example.demo.controller;

import com.example.demo.entity.Delivery;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

   @Autowired
   DeliveryService deliveryService;

   @PostMapping
   public Delivery saveDelivery(@RequestBody Delivery delivery){
      return deliveryService.save(delivery);
   }

   @GetMapping
   public List <Delivery> findAll(){
      return deliveryService.findAll();
   }
//   @PostMapping
//   public Long scheduleDelivery(@RequestBody Delivery delivery) {
//      return deliveryService.save(delivery);
//   }

//   @GetMapping("/bill/{deliveryId}")
//   public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
//      return deliveryService.getRecipientAndPrice(deliveryId);
//   }
}