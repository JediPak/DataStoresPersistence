package com.example.demo.service;

import com.example.demo.controller.RecipientAndPrice;
import com.example.demo.entity.Delivery;
import com.example.demo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DeliveryService {
   @Autowired
   DeliveryRepository deliveryRepository;

   @PersistenceContext
   EntityManager entityManager;

   public List <Delivery> findAll(){
      return deliveryRepository.findAll();
   }

   public Delivery save(Delivery delivery){
      return deliveryRepository.save(delivery);
   }
//   public Long save(Delivery delivery) {
//      delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
//      deliveryRepository.persist(delivery);
//      return delivery.getId();
//   }
//
//   public RecipientAndPrice getRecipientAndPrice(Long deliveryId){
//      return deliveryRepository.getRecipientAndPrice(deliveryId);
//   }

}