package com.example.demo;

import com.example.demo.entity.Delivery;
import com.example.demo.entity.Plant;
import com.example.demo.repository.PlantRepository;
import org.h2.table.Plan;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
class DemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PlantRepository plantRepository;

	@Test
	void contextLoads() {
	}

//	Adds two new plants to your database with two different prices.
//	Use the PlantRepository.findByPriceLessThan method to make sure the correct plant is returned.
	@Test
	public void testPriceLessThan(){
		Plant expensivePlant = entityManager.persist(
				new Plant(null, "rose", new BigDecimal("4.5"), null));
		Plant cheaperPlant = entityManager.persist(
				new Plant(null, "daisy", new BigDecimal("2.5"), null));
		List <Plant> actual = plantRepository.findByPriceLessThan(new BigDecimal("3.5"));
		List <Plant> expected = new ArrayList<>();
		expected.add(cheaperPlant);
		System.out.println("expected: "+ expected);
		System.out.println("actual: "+ expected);
		assertTrue(actual.equals(expected));
	}

//	Create a new Plant and a new Delivery.
//	Set both sides of their bi-directional relationship.
//	Verify that PlantRepository.deliveryCompleted
//		returns false for the plant you just created.
//	Then, set the Delivery to true and verify that deliveryCompleted returns true.
	@Test
	public void testDeliveryCompleted(){
		Plant plant = entityManager.persist(
				new Plant(null, "rose", new BigDecimal("4.5"), null));
		List <Plant> plantList = new ArrayList <>();
		plantList.add(plant);
		Delivery delivery = entityManager.persist(
				new Delivery(null, "Kim", "address", LocalDateTime.now(), true, plantList));
		plant.setDelivery(delivery);
		entityManager.merge(plant);

		Boolean actual = plantRepository.deliveryCompleted(plant.getId());
		assertTrue(actual);
		delivery.setCompleted(false);
		actual = plantRepository.deliveryCompleted(plant.getId());
		assertFalse(actual);
	}
}
