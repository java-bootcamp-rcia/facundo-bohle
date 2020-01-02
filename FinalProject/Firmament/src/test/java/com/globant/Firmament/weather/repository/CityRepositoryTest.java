package com.globant.Firmament.weather.repository;

import com.globant.Firmament.weather.model.City;
import com.globant.Firmament.weather.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void canFindSavedByCityName() {
        City savedCity = entityManager.persistFlushFind(new City("Corrientes","Argentina",-27.555,-58.6666));
        City city = cityRepository.findByName("Corrientes");

        assertEquals(savedCity.getName(),city.getName());
    }
}
