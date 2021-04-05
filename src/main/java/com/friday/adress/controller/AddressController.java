package com.friday.adress.controller;

import com.friday.adress.model.Adress;
import com.friday.adress.service.IAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final IAdressService service;

    @Autowired
    private AddressController(final IAdressService service) {
        this.service = service;
    }

    @RequestMapping(value = "/adress/{adress}", method = RequestMethod.GET)
    public ResponseEntity<Adress> getAdres(@PathVariable String adress) {
        return new ResponseEntity<>(service.getAdress(adress), HttpStatus.OK);
    }

}
