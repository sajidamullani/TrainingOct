package com.mastek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.mastek.exception.BusinessException;
import com.mastek.exception.ControllerException;
import com.mastek.model.Product;
import com.mastek.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService service;

	
	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		try {
		Product productSaved = service.createProduct(product);
		return new ResponseEntity<Product>(productSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		ControllerException ce = new ControllerException("800","Something went wrong in controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		}

	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Long id){
		try {
		Product productSaved = service.getProduct(id);
		return new ResponseEntity<Product>(productSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		ControllerException ce = new ControllerException("801","Something went wrong in controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		}

	
	@PutMapping("/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		try {
		Product productSaved = service.updateProduct(product);
		return new ResponseEntity<Product>(productSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
		return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		ControllerException ce = new ControllerException("802","Something went wrong in controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		}

	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		try {
		service.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch (BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
		ControllerException ce = new ControllerException("803","Something went wrong in controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		}


	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return service.getAllProducts();
	}
}
