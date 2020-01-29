/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;

import model.Star;

/**
 * @author kevinbusch
 *
 */
public class StarService extends AbstractService{
	public void createStar() {
		Star s1 = new Star();
		em.getTransaction().begin();
		em.persist(s1);
		em.getTransaction().commit();
		}
	@SuppressWarnings("unchecked")
	public void showAllStars() {
		Query query = em.createNamedQuery("findAllStars");
		List<Star> st = query.getResultList();
		for (Star star : st) {
			System.out.println(star);
		}
	}

}
