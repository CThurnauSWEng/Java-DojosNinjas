package com.carthurnau.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carthurnau.dojosninjas.models.Ninja;
import com.carthurnau.dojosninjas.repositories.ninjaRepository;

@Service
public class ninjaService {

	private final ninjaRepository ninjaRepository;
	
	public ninjaService(ninjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> findAll(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findById(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
