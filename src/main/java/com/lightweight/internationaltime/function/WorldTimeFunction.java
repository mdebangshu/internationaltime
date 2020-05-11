package com.lightweight.internationaltime.function;

import java.util.function.Function;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lightweight.internationaltime.model.Country;
import com.lightweight.internationaltime.model.WorldTime;
import com.lightweight.internationaltime.service.CountryValidatorService;
import com.lightweight.internationaltime.service.WorldTimeService;

@Component
public class WorldTimeFunction implements Function<Country, WorldTime> {

	private static Log logger = LogFactory.getLog(WorldTimeFunction.class);

	@Autowired
	private WorldTimeService worldTimeService;
	
	@Autowired
	private CountryValidatorService countryValidatorService;

	@Override
	public WorldTime apply(Country country) {
		String validity = countryValidatorService.getValidity(country.getCountry());
		if(!"Valid".equals(validity)) {
			throw new RuntimeException("Invalid Country");
		}
		logger.info("Fetching current time of Country : " + country.getCountry());
		return worldTimeService.getWorldTime(country.getCountry());
	}
}