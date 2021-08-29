package com.example.demo.repository;

import com.example.demo.controller.RecipientAndPrice;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Plant;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@NamedQueries({
        @NamedQuery(
                name = "Delivery.findAllDeliveryByName",
                query = "select d from Delivery d" +
                        "where d.name = :name"
        )
})
//public class DeliveryRepository {
public interface DeliveryRepository extends JpaRepository <Delivery, Long>{

//   @PersistenceContext
//   EntityManager entityManager = null;
//
//   //saves delivery
//   public void persist(Delivery delivery){
//      entityManager.persist(delivery);
//   }
//
//   //gets delivery
//   public Delivery find(Long id){
//      return entityManager.find(Delivery.class, id);
//   }
//
//   //updates delivery
//   public Delivery merge(Delivery delivery){
//      return entityManager.merge(delivery);
//   }
//
//   //deletes delivery
//   public void delete(Long id) throws Exception {
//      Delivery delivery = entityManager.find(Delivery.class, id);
//      if (delivery == null){
//         throw new Exception("Nothing to delete");
//      }
//      entityManager.remove(delivery);
//   }
//
//   /*Create a Named Query that returns a list of all Deliveries for a specified Name.
//   Add a new method to your Delivery Repository that uses this query.
//   It should accept a String name and return a List of Delivery Entities..*/
//   public List<Delivery> getAllDeliveryFromName(String name){
//      List<Delivery> deliveryList = new ArrayList <>();
//      TypedQuery<Delivery> query =
//              entityManager.createNamedQuery("Delivery.findAllDeliveryByName", Delivery.class);
//      query.setParameter("name", name);
//      return query.getResultList();
//   }
//
//
//   /* Now let’s create a new method in DeliveryRepository that
//   uses CriteriaBuilder to populate an instance of the RecipientAndPrice class.
//   This method should take a Long deliveryId and
//   return a RecipientAndPrice that contains the
//      name of the delivery recipient and
//      the sum of the prices of plants in their order.
//   */
//   public RecipientAndPrice getRecipientAndPrice(Long deliveryId){
//      CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//      CriteriaQuery <RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
//      Root <Plant> root = query.from(Plant.class);
//      query.select(
//              cb.construct(
//                      RecipientAndPrice.class,
//                      root.get("delivery").get("name"),
//                      cb.sum(root.get("price"))))
//              .where(cb.equal(root.get("delivery").get("id"), deliveryId));
//      return entityManager.createQuery(query).getSingleResult();
//   }
}
