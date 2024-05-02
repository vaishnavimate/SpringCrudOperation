package com.CrudOperation.CrudOperation.Dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CrudOperation.CrudOperation.Entity.Product;



@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(Product p) {

		Session session= factory.openSession();
		session.beginTransaction();
		session.persist(p);
		session.getTransaction().commit();
		session.close();
		return "Record is Saved";


}
public String updateData(int id , Product p) {
	Session session= factory.openSession();
	session.beginTransaction();

	Product   dbRecord= session.get(Product .class,id );

	
	dbRecord.setId(p.getId());
	dbRecord.setName(p.getName());
	dbRecord.setPrice(p.getPrice());
	dbRecord.setDescription(p.getDescription());

	session.merge(dbRecord);

	session.getTransaction().commit();
	session.close();

	return "Data is Updatated....";				

}

public String deleteData(int id) {

	Session session= factory.openSession();
	session.beginTransaction();

	Product p= session.get(Product .class, id);
	session.remove(p);
	session.getTransaction().commit();
	session.close();

	return "Record is Deleted Successfully";


}

public Product  getParticularRecord(int id) {

	Session session= factory.openSession();
	session.beginTransaction();

	String hqlQuery="from Student  where id=:myid";

	Query<Product > query= session.createQuery(hqlQuery,Product .class);
	query.setParameter("myid",id );

	Product s= query.uniqueResult();
	session.getTransaction().commit();
	session.close();		
	return s;		
}


//public List<Product > getAllRecord() {
//
//	Session session= factory.openSession();
//	session.beginTransaction();
//
//	String hqlQuery="from Student ";
//
//	Query<Product > query= session.createQuery(hqlQuery,Product .class);
//
//	List<Product > list= query.list();
//	session.getTransaction().commit();
//	session.close();	
//
//	return list;		
//
//}



public List<Product> getAllRecord(int pageNumber, int pageSize) {
    Session session = null;
    try {
        session = factory.openSession();
        session.beginTransaction();

        String hqlQuery = "from Product";

        Query<Product> query = session.createQuery(hqlQuery, Product.class);

        int start = (pageNumber - 1) * pageSize;
        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        List<Product> list = query.list();
        session.getTransaction().commit();
        return list;
    } catch (Exception e) {
        if (session != null && session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        // Handle exception
        e.printStackTrace();
        return null; // Or throw an exception
    } finally {
        if (session != null) {
            session.close();
        }
    }
}


}
