package com.chris.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.dojosandninjas.models.Ninja;
import com.chris.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> potentialNinja = ninjaRepo.findById(id);
		return potentialNinja.isPresent() ? potentialNinja.get() : null;
	}
	
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja update(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	
	
	
}
