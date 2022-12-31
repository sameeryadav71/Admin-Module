package com.cbic.microservices.login.loginservice;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Entity;

import org.springframework.stereotype.Repository;

import com.cbic.microservices.login.loginservice.user.User;



@Repository
public class LoginDataDao {

	@PersistenceContext
	private EntityManager em;	

//	private static final Logger logger = Logger.getLogger(LoginDataDao.class);	

	public List<String> getUserRoles(String username) throws Exception {
	//	logger.info("Getting into the method getUserRoles method of MasterDataDao");
		try {
			//Query query = em.createNamedQuery("getUserRole");
			Query query = em
					.createQuery("select rol from User rol  where  rol.email = :username",User.class);
			query.setParameter("username", username);
			//query.setParameter("email", username);
			List<String> userRoles = query.getResultList();

			return userRoles;
		} catch (Exception ex) {
			//logger.error("Error in fetching user roles", ex);
			System.err.println(ex); 
			return null;
		}
	}

	public List<String> getUserRolesName(String username) throws Exception {
		//logger.info("Getting into the method getUserRolesName method of MasterDataDao");
		try {
			Query query = em.createNamedQuery("getUserRoleName");
			query.setParameter("UserID", username);
			List<String> userRoles = query.getResultList();

			return userRoles;
		} catch (Exception ex) {
		//	logger.error("Error in fetching user roles name", ex);
			return null;
		}
	}

	

}
