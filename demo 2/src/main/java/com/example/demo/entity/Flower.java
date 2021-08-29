package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flower extends Plant{
//   @Id
//   @GeneratedValue
//   private Long id;
//   private String name;
   private String color;
//   private Double price;

//   public Long getId() {
//      return id;
//   }
//
//   public void setId(Long id) {
//      this.id = id;
//   }
//
//   public String getName() {
//      return name;
//   }
//
//   public void setName(String name) {
//      this.name = name;
//   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

//   public Double getPrice() {
//      return price;
//   }
//
//   public void setPrice(Double price) {
//      this.price = price;
//   }
}
