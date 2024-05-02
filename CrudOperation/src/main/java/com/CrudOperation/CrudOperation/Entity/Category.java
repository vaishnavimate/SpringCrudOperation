package com.CrudOperation.CrudOperation.Entity;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Cid;
	
	@Column(unique = true)
	private String Cname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk-product-id", referencedColumnName = "Cid")
	private List<Product> product;
	
	
    public Category() {
		
	}

	public Category(int cid, String cname, List<Product> product) 
	{
	super();
	Cid = cid;
	Cname = cname;
	this.product = product;
	}
	
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [Cid=" + Cid + ", Cname=" + Cname + ", product=" + product + "]";
	}
	
	
	
	
	
	
	
	
	

}
