package com.takefour.themoment.themoment;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.takefour.themoment.themoment.model.City;
import com.takefour.themoment.themoment.model.Moment;
import com.takefour.themoment.themoment.model.Place;
import com.takefour.themoment.themoment.model.User;
import com.takefour.themoment.themoment.repository.MomentRepository;
import com.takefour.themoment.themoment.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class TheMomentApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MomentRepository momentRepository;

	@Test
	public void userTest() {
		User user = new User();
		user.setEmail("byeol3058@gmail.com");
		user.setName("hanbyeol");

		entityManager.persist(user);

		List<User> users = userRepository.findAll();
		assertThat(users)
				.isNotEmpty()
				.hasSize(1)
				.contains(user);
	}

	@Test
	public void momentTest() {
		Moment moment = new Moment();
		moment.setCreateDate(LocalDateTime.now());
		moment.setDescription("테스트");

		City city = new City();
		entityManager.persist(city);

		Place place = new Place();
		place.setCityId(0);
		entityManager.persist(place);

		moment.setCity(city);
		moment.setPlace(place);
		entityManager.persist(moment);

		Moment one = momentRepository.findAll().get(0);
		assertThat(one.getDescription())
				.isEqualTo("테스트");
	}
}
