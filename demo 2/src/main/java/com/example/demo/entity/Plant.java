package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
   @Id
   @GeneratedValue
   private Long id;

   @JsonView(Views.Public.class)
   @Nationalized // should use @Nationalized instead of @Type=nstring
   private String name;

   @JsonView(Views.Public.class)
   @Column(precision=12, scale=4)
   private BigDecimal price; // BigDecimal is the standard Java class for currency math

   @ManyToOne(fetch = FetchType.LAZY) //many plants can belong to one delivery
   @JoinColumn(name = "delivery_id")  //map the join column in the plant table
   private Delivery delivery;

   public Plant() {
   }

   public Plant(Long id, String name, BigDecimal price, Delivery delivery) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.delivery = delivery;
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

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public Delivery getDelivery() {
      return delivery;
   }

   public void setDelivery(Delivery delivery) {
      this.delivery = delivery;
   }

   /* getters and setters*/

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Plant)) return false;
      Plant plant = (Plant) o;
      return Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(price, plant.price) && Objects.equals(delivery, plant.delivery);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, price, delivery);
   }

   @Override
   public String toString() {
      return "Plant{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", price=" + price +
              ", delivery=" + delivery +
              '}';
   }

}