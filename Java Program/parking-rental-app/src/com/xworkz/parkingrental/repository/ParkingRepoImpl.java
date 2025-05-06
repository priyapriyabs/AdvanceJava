package com.xworkz.parkingrental.repository;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import com.xworkz.parkingrental.entity.ParkingEntity;
import com.xworkz.parkingrental.entity.ParkingInfoEntity;
import com.xworkz.parkingrental.entity.UserEntity;
import com.xworkz.parkingrental.entity.UserParkingEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ParkingRepoImpl implements ParkingRepo {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");

	public boolean updateLoginTime(ParkingEntity entity) {
		log.info("running updateLoginTime()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return false;
	}

	public ParkingEntity findByEmail(String email) {
		log.info("running findByEmail");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByEmail");
		query.setParameter("ss", email);
		try {
			Object row = query.getSingleResult();
			ParkingEntity entity = (ParkingEntity) row;
			return entity;
		} catch (Exception e) {
			log.info("no record found");
			return null;
		}
	}

	// to update parking info
	// tocheck whether the details are exist or not
	public ParkingInfoEntity findByLocationAndVehicleTypeAndEngineTypeAndClsAndTerm(String location, String vehicleType,
			String engineType, String classification, String term) {
		log.info("running findByLocationAndVehicleTypeAndEngineTypeAndClsAndTerm()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByLTTCT");
		query.setParameter("lc", location);
		query.setParameter("vtype", vehicleType);
		query.setParameter("etype", engineType);
		query.setParameter("cls", classification);
		query.setParameter("trm", term);
	
		try {
			Object entity = query.getSingleResult();
			return (ParkingInfoEntity) entity;
		} catch (Exception e) {
			log.info("no record found");
			return null;
		}
	}

	public boolean saveParkingInfo(ParkingInfoEntity entity) {
		log.info("running saveParkingInfo()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ParkingInfoEntity> findByLocation(String location) {
		log.info("running findByLocation()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByLocation");
		query.setParameter("lc", location);
		try {
			
			List<ParkingInfoEntity> list = query.getResultList();
			return list;
		} catch (Exception e) {
			log.info(e.getMessage());
			return Collections.emptyList();
		}
	}

	public UserEntity findByUserEmail(String email) {
		log.info("running findByUserEmail()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByUserEmail");
		query.setParameter("mail", email);
		try {
			Object obj = query.getSingleResult();
			UserEntity entity= (UserEntity) obj;
			log.info("repo: findByUserEmail: entity: "+entity);
			 return entity;
		} catch (Exception e) {
		//	e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	public boolean saveUserData(UserEntity entity) {
		log.info("running saveUserData()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveUserParkingInfo(UserParkingEntity entity) {
		log.info("running saveUserParkingInfo()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserEntity(UserEntity entity) {
		log.info("running updateUserEntity()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
	}
	
	public List<UserParkingEntity> findAllByUserId(Integer id){
		log.info("running findAllByUserId()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findAllByUserId");
		query.setParameter("uId", id);
		query.setParameter("status", true);
		try {
			@SuppressWarnings("unchecked")
			List<UserParkingEntity> upList= query.getResultList();
			log.info("repo: findAllByUserId: upList: "+upList);
			 return upList;
		} catch (Exception e) {
		//	e.printStackTrace();
			return Collections.emptyList();
		} finally {
			manager.close();
		}
	}
	
	public UserParkingEntity findByVehicleNo(String vehicleNo) {
		log.info("running findByVehicleNo()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByVehicleNo");
		query.setParameter("vNo", vehicleNo);
		try {
			UserParkingEntity entity= (UserParkingEntity) query.getSingleResult();
			 return entity;
		}catch (Exception e) {
			return null;
		}finally {
			manager.close();
		}
	}
	
	public boolean updateUserParkingInfo(UserParkingEntity entity) {
		log.info("running updateUserParkingInfo()");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
	}
	
	public boolean deleteUserParkingEntity(String vehicleNo) {
		log.info("running deleteUserParkingEntity()");
		boolean flag=true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
		String formattedDate = dateFormat.format(new Date());
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Query query = manager.createNamedQuery("findByVehicleNo");
		query.setParameter("vNo", vehicleNo);
		
		try {
			UserParkingEntity entity = (UserParkingEntity) query.getSingleResult();
			if(manager.contains(entity)){
				log.info("contains entity");
				flag=false;
				entity.setActive(flag);
				entity.setUpdatedDate(formattedDate);
				transaction.begin();
				manager.merge(entity);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
		return false;
	}
	
	
	public List<UserParkingEntity> findAll() {
		log.info("running deleteUserParkingEntity()");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findAllEntities");
		try {
			List<UserParkingEntity> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			manager.close();
		}
	}
}
