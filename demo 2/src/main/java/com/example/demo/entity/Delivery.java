package com.example.demo.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {
   @Id
   @GeneratedValue
   private Long id;

   @Nationalized
   private String name;
   @Column(name = "address_full", length = 500)
   private String address;
   // includes both date and time - simpler than having two separate fields
   private LocalDateTime deliveryTime;
   @Type(type = "yes_no")
   private Boolean completed = false;

   //make sure to specify mappedBy. Lazy fetch optional,
   //  but often a good idea for collection attributes
   // added CascadeType.REMOVE to automatically clear any associated plants when removed
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery",
           cascade = CascadeType.ALL)
//           cascade = CascadeType.REMOVE)
   private List<Plant> plants;

   public Delivery() {
   }

   public Delivery(Long id, String name, String address, LocalDateTime deliveryTime, Boolean completed, List <Plant> plants) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.deliveryTime = deliveryTime;
      this.completed = completed;
      this.plants = plants;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public LocalDateTime getDeliveryTime() {
      return deliveryTime;
   }

   public void setDeliveryTime(LocalDateTime deliveryTime) {
      this.deliveryTime = deliveryTime;
   }

   public Boolean getCompleted() {
      return completed;
   }

   public void setCompleted(Boolean completed) {
      this.completed = completed;
   }

   public List <Plant> getPlants() {
      return plants;
   }

   public void setPlants(List <Plant> plants) {
      this.plants = plants;
   }

   @Override
   public String toString() {
      return "Delivery{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", address='" + address + '\'' +
              ", deliveryTime=" + deliveryTime +
              ", completed=" + completed +
              ", plants=" + plants +
              '}';
   }
}
