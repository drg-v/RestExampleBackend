package com.example.demo.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Inhabitant;
import com.example.demo.services.InhabitantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InhabitantController {
	
	InhabitantService<Inhabitant> inhabitantService;
	
	@Autowired
	public InhabitantController(InhabitantService<Inhabitant> inhabitantService) {
		super();
		this.inhabitantService = inhabitantService;
	}
	
	@GetMapping("/inhabitants")
	public Collection<Inhabitant> getAll() {
		return inhabitantService.getAll();
	}
	
	@GetMapping("/inhabitants/{id}")
	public Inhabitant get(@PathVariable("id") int id) {
		return inhabitantService.read(id);
	}
	
	@PostMapping("/inhabitants/new")
	public void postInhabitant(@RequestBody Inhabitant inhabitant) {
		System.out.println(inhabitant);
		inhabitantService.create(inhabitant);
	}
	
	@PutMapping("/inhabitants/update")
	public void updateInhabitant(@RequestBody Inhabitant inhabitant) {
		System.out.println(inhabitant);
		inhabitantService.update(inhabitant);
	}
	
	@DeleteMapping("/inhabitants/delete/{id}")
	public void deleteInhabitant(@PathVariable("id") int id) {
		System.out.println(id);
		inhabitantService.delete(id);
	}
	
}
