package com.friday.adress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friday.adress.model.Adress;
import com.friday.adress.service.IAdressService;

@RestController
public class AdressController {
	
	@Autowired
	private IAdressService service;
	
	@RequestMapping(value = "/adress/{adress}", method = RequestMethod.GET)
	public ResponseEntity<Adress> getAdres(@PathVariable String adress) {
		return new ResponseEntity<Adress>(service.getAdress(adress), HttpStatus.OK);
	}

}
