package com.CrudOperation.CrudOperation.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.CrudOperation.CrudOperation.Entity.Product;
import com.CrudOperation.CrudOperation.service.ProductService;


@RestController
@RequestMapping("/api1")
public class ProductController {
	
	@Autowired
	ProductService service;

	@PostMapping("/Ssavedata")
	public String saveRecord(@RequestBody Product p) {

		String msg= service.InsertData(p);

		return msg;

	}
	@PutMapping("/updatedata/{id}")
	public String UpdateRecors(@PathVariable int id,@RequestBody Product p) {

		String msg= service.Updatedata(id, p);
		return msg;

	}

	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg= service.DeleteData(id);
		return msg;
	}

	@GetMapping("/getparticulardata/{id}")
	public Product   getParticularRecordById(@PathVariable int id) {

		Product p = service.getParticularRecord(id);
		return p;		
	}

//	@GetMapping("/getAll")
//	public List<Product  > getAllRecord(){
//
//		List<Product  > list= service.getAllRecord();
//		return list;
//
//	}
	
	@GetMapping("/getAll")
	public List<Product> getAllRecord(
	    @RequestParam(defaultValue = "1") int pageNumber,
	    @RequestParam(defaultValue = "10") int pageSize) {
	    
	    return service.getAllRecord(pageNumber, pageSize);
	}

}

