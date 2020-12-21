package com.friday.adress.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.friday.adress.exception.MissingFileException;
import com.friday.adress.exception.PatternNotFoundException;
import com.friday.adress.model.Adress;
import com.friday.adress.util.Constants;

@Service
public class AdressService implements IAdressService{

	/**
	 * Method responsibe for separating the street name from a house number based on the regex adress patterns.
	 */
	@Override
	public Adress getAdress(String adress) {
		List<String> patternsList   = new ArrayList<String>();
		Adress       adressReturned = new Adress();
		
		patternsList = getAdressPatterns();
			
		patternsList.forEach(iterator ->{
			Pattern pattern = Pattern.compile(iterator);
		    Matcher m       = pattern.matcher(adress);
			if (m.matches()){
					String number = m.group(Character.isDigit(adress.charAt(0)) ? 1 : 2);
					String street = m.group(Character.isDigit(adress.charAt(0)) ? 2 : 1);
					
					adressReturned.setHouseNumber(number);
					adressReturned.setStreet(street);
			}
		});
		
		if(adressReturned.getHouseNumber() == null || adressReturned.getStreet() == null) {
			throw new PatternNotFoundException(Constants.PATTERN_NOT_FOUND_EXCEPTION + adress);
		}
		return adressReturned;
	}

	/**
	 * Method responsible for getting the adress patterns from a external file.
	 * @return
	 */
	public List<String> getAdressPatterns() {
		List<String> ptrnList = new ArrayList<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(Constants.REGEX_PATTERNS_PATH))) {
            stream.forEach(line -> {
            	ptrnList.add(line);
            });
        } catch (IOException e) {
        	throw new MissingFileException(Constants.MISSING_FILE_EXCEPTION + Constants.REGEX_PATTERNS_PATH);
        }
		return ptrnList;
	}

}
