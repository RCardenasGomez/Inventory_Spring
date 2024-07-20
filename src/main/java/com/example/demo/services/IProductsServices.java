package com.example.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.response.ProductResponseRest;


public interface IProductsServices {
	public ResponseEntity<ProductResponseRest> save(Product product, Long categoryId);
	public ResponseEntity<ProductResponseRest> searchById(Long id);
	public ResponseEntity<ProductResponseRest> searchByName(String name);
	public ResponseEntity<ProductResponseRest> deleteById(Long id);
	public ResponseEntity<ProductResponseRest> search(Authentication connectedUser);
	public ResponseEntity<ProductResponseRest> updateProducts(Product product, Long categoryId, Long id);
}
