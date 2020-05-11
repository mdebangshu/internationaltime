package com.lightweight.internationaltime.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightweight.internationaltime.entity.CountryValidator;
import com.lightweight.internationaltime.repositories.CountryValidatorRepository;

@Service
public class CountryValidatorService {

	@Autowired
	private CountryValidatorRepository repository;

	public String getValidity(String id) {
		Optional<CountryValidator> result = repository.findById(id);
		return result.isPresent() ? result.get().getValidity() : "";
	}
}