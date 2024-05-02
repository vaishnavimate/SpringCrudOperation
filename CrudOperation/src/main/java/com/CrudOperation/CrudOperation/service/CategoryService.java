package com.CrudOperation.CrudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrudOperation.CrudOperation.Dao.CategoryDao;
import com.CrudOperation.CrudOperation.Entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;
	
	public String InsertData(Category c) {

		String msg= dao.insertData(c);
		return msg;

}
	public String UpdateData(int Cid, Category c) {
		String msg= dao.updateData(Cid, c);
		return msg;

	}

	public String DeleteData(int Cid) {

		String msg= dao.deleteData(Cid);
		return msg;

	}

	public  Category getParticularRecord(int Cid) {
		Category c = dao.getParticularRecord(Cid);
		return c;
	}


//	public List<Category> getAllRecord(){
//		
//		int pageNumber=1;
//		
//		 List<Category> list= dao.getAllRecord();
//		 return list;
//	}
	
	public List<Category> getAllRecord(int pageNumber, int pageSize) {
	    int startIndex = (pageNumber - 1) * pageSize;
	    List<Category> list = dao.getAllRecord(startIndex, pageSize);
	    return list;
	}


}
