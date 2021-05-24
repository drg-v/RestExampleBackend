package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InhabitantDao;
import com.example.demo.model.Inhabitant;

@Service
public class InhabitantServiceImpl implements InhabitantService<Inhabitant>{
	
	private InhabitantDao inhabitantDao;
	
	@Autowired
	public InhabitantServiceImpl(InhabitantDao inhabitantDao) {
		this.inhabitantDao = inhabitantDao;
	}
	
	@Override
	public Collection<Inhabitant> getAll() {
		return inhabitantDao.getAll();
	}

	@Override
	public void create(Inhabitant inhabitant) {
		inhabitantDao.create(inhabitant);
	}

	@Override
	public void update(Inhabitant inhabitant) {
		inhabitantDao.update(inhabitant);
	}

	@Override
	public Inhabitant read(Integer hab_id) {
		return inhabitantDao.read(hab_id);
	}

	@Override
	public void delete(Integer hab_id) {
		inhabitantDao.delete(hab_id);
	}

}
