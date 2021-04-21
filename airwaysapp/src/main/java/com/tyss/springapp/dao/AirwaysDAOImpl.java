package com.tyss.springapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.springapp.dto.UserDetails;
@Repository
public class AirwaysDAOImpl implements AirwaysDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public UserDetails getDetaillByID(int id) {
		EntityManager manager=factory.createEntityManager();
		UserDetails details=manager.find(UserDetails.class, id);
		if(details!=null) {
			return details;
		}else {
		return null;
	}
	}// End OF The getDetaillByID

	@Override
	public boolean deleteByID(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = "delete from UserDetails ud where ud.id=:idd";
		transaction.begin();
		Query query = manager.createQuery(jpql);
		query.setParameter("idd", id);
		int record=query.executeUpdate();
		if (record != 0) {
			return true;
		} else {
			return false;
		}
	}// End OF The deleteByID

	@Override
	public boolean createDetail(UserDetails info) {
		boolean status = false;

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			System.out.println("Record Inserted");
			status = true;
		} catch (Exception e) {
			transaction.rollback(); // rollback if any exception
			status = false;
			e.printStackTrace();
		}

		manager.close();

		return status;
	}

	@Override
	public boolean updateDetail(UserDetails info) {
		EntityManager manager = null;
		EntityTransaction tx = null;
	//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		try {
			manager = factory.createEntityManager();
			tx = manager.getTransaction();
			String jpql="update UserDetails u set u.fname=:fnamee where e.id=:idd";
			tx.begin();
			
			Query query=manager.createQuery(jpql);
			query.setParameter("fnamee", info.getFname());
			query.setParameter("idd", info.getSurname());			
			int record=query.executeUpdate();
			tx.commit();
if(record!=0) {
		return true;
		} else {
			return false;
		}
		}catch (

		Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		manager.close();
		return false;
	}


	@Override
	public List<UserDetails> getAllDetail() {
		EntityManager manger = factory.createEntityManager();
		String jpql = "select e from UserDetails e";
		Query qry = manger.createQuery(jpql);
		List<UserDetails> employees = qry.getResultList();
		return employees;
	}

}
