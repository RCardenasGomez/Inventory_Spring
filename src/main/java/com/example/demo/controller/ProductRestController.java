package com.example.demo.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.response.ProductResponseRest;
import com.example.demo.services.IProductsServices;
import com.example.demo.utils.Util;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Tag(name = "Products")
public class ProductRestController {
	private IProductsServices productService;
	
	public ProductRestController(IProductsServices productService) {
		super();
		this.productService = productService;
	}
	/**
	 * 
	 * @param picture
	 * @param name
	 * @param price
	 * @param account
	 * @param categoryId
	 * @return
	 * @throws IOException
	 */
	@PostMapping
	
	public ResponseEntity<ProductResponseRest> save(@RequestParam("picture") MultipartFile picture,
			@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("account") int account,
			@RequestParam("categoryId") Long categoryId, Authentication connectedUser)throws IOException 
	{
		Product product = new Product();
		product.setName(name);
		product.setAccount(account);
		product.setPrice(price);
		product.setPicture(Util.compressZLib(picture.getBytes()));
		
		ResponseEntity<ProductResponseRest> response = productService.save(product, categoryId);
		
		
		return response;
	};
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id){
		ResponseEntity<ProductResponseRest> response = productService.searchById(id);
		return response;
		
	}
	
	@GetMapping("/filter/{name}")
	public ResponseEntity<ProductResponseRest> searchByName(@PathVariable String name){
		ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
		return response;
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductResponseRest> deleteById(@PathVariable Long id){
		ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
		return response;
	}
	/**
	 * 
	 */
	@GetMapping
	public ResponseEntity<ProductResponseRest> search(@PathVariable Authentication connectedUser){
		ResponseEntity<ProductResponseRest> response = productService.search(connectedUser);
		return response;
	}
	/**
	 * Update Products
	 * @param picture
	 * @param name
	 * @param price
	 * @param account
	 * @param categoryId
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseRest> updateProducts(@RequestParam("picture") MultipartFile picture,
			@RequestParam("name") String name, @RequestParam("price") int price, @RequestParam("account") int account,
			@RequestParam("categoryId") Long categoryId, @PathVariable Long id)throws IOException 
	{
		Product product = new Product();
		product.setName(name);
		product.setAccount(account);
		product.setPrice(price);
		product.setPicture(Util.compressZLib(picture.getBytes()));
		
		ResponseEntity<ProductResponseRest> response = productService.updateProducts(product, categoryId, id);
		
		
		return response;
	};
	
	
	
}
