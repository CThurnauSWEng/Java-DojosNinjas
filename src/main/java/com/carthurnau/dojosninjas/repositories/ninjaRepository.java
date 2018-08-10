package com.carthurnau.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carthurnau.dojosninjas.models.Ninja;

@Repository
public interface ninjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
