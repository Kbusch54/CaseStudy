/**
 * 
 */
package com.KevinBusch.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author kevinbusch
 *
 */
public abstract class AbstractService {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CaseStudy");
	protected static EntityManager em = emf.createEntityManager();
	
	public AbstractService() {
		
	}
	public static void close() {
		em.close();
		emf.close();
	}

}
