package com.rolex.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rolex.entity.ProductEntity;

@Repository
public class ProductRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public String uploadProduct(String dataID,String productName,String qty,String productPrice) {
//		String productIDD = java.util.UUID.nameUUIDFromBytes(dataID.getBytes()).toString();
		System.out.println("data from repositry ::: dataID "
				+ ""+dataID+"productName is "+productName+"Quanity is "+qty+"ProductPrice is "+productPrice);
		ProductEntity entity = new ProductEntity(dataID,productName,qty,productPrice);
		System.out.println("data from repositry ::: "+entity);
		String prodId = (String) sessionFactory.getCurrentSession().save(entity);
		System.out.println("prodId ::"+prodId);
		return prodId;
	}

}
