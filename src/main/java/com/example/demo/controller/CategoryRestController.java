package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.response.Category_ResponseRest;
import com.example.demo.services.ICategoryServices;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("categories")
public class CategoryRestController {
	@Autowired
	private ICategoryServices service;
	@GetMapping
	public ResponseEntity<Category_ResponseRest> searchCategories(){
		ResponseEntity<Category_ResponseRest> response = service.search();
		return response;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category_ResponseRest> searchCategoriesById(@PathVariable Long id){
		ResponseEntity<Category_ResponseRest> response = service.searchById(id);
		return response;
	}
	@PostMapping
	public ResponseEntity<Category_ResponseRest> save(@RequestBody Category category){
		ResponseEntity<Category_ResponseRest> response = service.save(category);
		return response;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Category_ResponseRest> update(@RequestBody Category category, @PathVariable Long id ){
		ResponseEntity<Category_ResponseRest> response = service.update(category, id);
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Category_ResponseRest> deleteById(@PathVariable Long id ){
		ResponseEntity<Category_ResponseRest> response = service.deleteById(id);
		return response;
	}
	
}