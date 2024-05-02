package com.CrudOperation.CrudOperation.Dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CrudOperation.CrudOperation.Entity.Category;


@Repository
public class CategoryDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(Category c) {

		Session session= factory.openSession();
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();
		session.close();
		return "Record is Saved";
}
	public String updateData(int Cid , Category  c) {
		Session session= factory.openSession();
		session.beginTransaction();

		Category dbRecord= session.get(Category.class,Cid );

		dbRecord.setCid(c.getCid());
		dbRecord.setCname(c.getCname());

		session.merge(dbRecord);

		session.getTransaction().commit();
		session.close();

		return "Data is Updatated....";				

	}

	public String deleteData(int Cid) {

		Session session= factory.openSession();
		session.beginTransaction();

		Category c = session.get(Category.class, Cid);
		session.remove(c);
		session.getTransaction().commit();
		session.close();

		return "Record is Deleted Successfully";


	}

	public Category getParticularRecord(int Cid) {

		Session session= factory.openSession();
		session.beginTransaction();

		String hqlQuery="from Country where id=:myid";

		Query<Category> query= session.createQuery(hqlQuery,Category.class);
		query.setParameter("myid",Cid );

		Category c = query.uniqueResult();
		session.getTransaction().commit();
		session.close();		
		return c;		
	}


//	public List<Category> getAllRecord() {
//
//		Session session= factory.openSession();
//		session.beginTransaction();
//
//		String hqlQuery="from Category";
//
//		Query<Category> query= session.createQuery(hqlQuery,Category.class);
//
//		List<Category> list= query.list();
//		session.getTransaction().commit();
//		session.close();	
//
//		return list;		
//
//	}
	
	public List<Category> getAllRecord(int pageNumber, int pageSize) {
	    Session session = null;
	    try {
	        session = factory.openSession();
	        session.beginTransaction();

	        String hqlQuery = "from Category";

	        Query<Category> query = session.createQuery(hqlQuery, Category.class);

	        // Set pagination parameters
	        query.setFirstResult((pageNumber - 1) * pageSize);
	        query.setMaxResults(pageSize);

	        List<Category> list = query.list();
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
