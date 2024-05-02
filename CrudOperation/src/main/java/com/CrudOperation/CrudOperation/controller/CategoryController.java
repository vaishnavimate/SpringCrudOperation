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

import com.CrudOperation.CrudOperation.Entity.Category;
import com.CrudOperation.CrudOperation.service.CategoryService;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@PostMapping("/savedata")
	public String saveRecord(@RequestBody Category c) {

		String msg= service.InsertData(c);

		return msg;

	}
	
	@PutMapping("/updateData/{Cid}")
	public String UpdateRecords(@PathVariable int Cid,@RequestBody Category c) {

		String msg= service.UpdateData(Cid, c);
		return msg;

	}

	@DeleteMapping("/deleteData/{Cid}")
	public String deleteData(@PathVariable int Cid) {
		String msg= service.DeleteData(Cid);
		return msg;
	}

	@GetMapping("/getparticulardata/{Cid}")
	public Category getParticularRecordById(@PathVariable int Cid) {

		Category c= service.getParticularRecord(Cid);
		return c;		
	}

//	@GetMapping("/getAll")
//	public List<Category> getAllRecord(){
//
//		List<Category> list= service.getAllRecord();
//		return list;
//
//	}
	
	@GetMapping("/getAll")
	public List<Category> getAllRecord(
	    @RequestParam(defaultValue = "1") int pageNumber,
	    @RequestParam(defaultValue = "10") int pageSize) {
	    
	    return service.getAllRecord(pageNumber, pageSize);
	}


	
	

}
