package com.chris.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.dojosandninjas.models.Dojo;
import com.chris.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> findAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> potentialDojo = dojoRepo.findById(id);
		return potentialDojo.isPresent() ? potentialDojo.get() : null;
	}

}
