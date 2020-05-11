package com.lightweight.internationaltime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightweight.internationaltime.adapter.WorldTimeAdapter;
import com.lightweight.internationaltime.model.WorldTime;

@Service
public class WorldTimeService {
	
	@Autowired
	private WorldTimeAdapter worldTimeAdapter;
	
	public WorldTime getWorldTime(String country) {
		return worldTimeAdapter.getWorldTime(country);
	}
}