package com.CrudOperation.CrudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrudOperation.CrudOperation.Dao.ProductDao;
import com.CrudOperation.CrudOperation.Entity.Category;
import com.CrudOperation.CrudOperation.Entity.Product;


@Service
public class ProductService {

	
	@Autowired
	ProductDao dao;
	
	
	public String InsertData(Product p) {

		String msg= dao.insertData(p);
		return msg;

}
public String Updatedata(int id,Product p) {
	String msg= dao.updateData(id, p);
	return msg;

}

public String DeleteData(int id) {

	String msg= dao.deleteData(id);
	return msg;

}

public Product getParticularRecord(int id) {
	Product s= dao.getParticularRecord(id);
	return s;
}


//public List<Product > getAllRecord(){
//	 List<Product > list= dao.getAllRecord();
//	 return list;
//}

public List<Product> getAllRecord(int pageNumber, int pageSize) {
    int startIndex = (pageNumber - 1) * pageSize;
    List<Product> list = dao.getAllRecord(startIndex, pageSize);
    return list;
}


}
