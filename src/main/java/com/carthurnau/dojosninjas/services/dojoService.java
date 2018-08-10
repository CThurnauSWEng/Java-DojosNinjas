package com.carthurnau.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carthurnau.dojosninjas.models.Dojo;
import com.carthurnau.dojosninjas.repositories.dojoRepository;

@Service
public class dojoService {

	private final dojoRepository dojoRepository;
	
	public dojoService(dojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

}
