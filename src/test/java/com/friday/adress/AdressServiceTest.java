package com.friday.adress;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.friday.adress.exception.PatternNotFoundException;
import com.friday.adress.model.Adress;
import com.friday.adress.service.AdressService;

@RunWith(SpringRunner.class)
public class AdressServiceTest {
	
	@TestConfiguration
	static class AdressServiceTestConfiguration {
		@Bean
		public AdressService adressService() {
			return new AdressService();
		}
	}
	
	@Autowired
	AdressService adressService;
	
	@Test
	public void getAdressTest() {
		String adressInput = "200 Broadway Av";
		Adress adressReturned = adressService.getAdress(adressInput);
		
		Assertions.assertEquals(adressReturned.getHouseNumber(), "200");
		Assertions.assertEquals(adressReturned.getStreet(), "Broadway Av");
	}
	
	@Test(expected = PatternNotFoundException.class)
	public void getAdressFailTest() {
		String adressInput = "Av";
		adressService.getAdress(adressInput);
	}

}
