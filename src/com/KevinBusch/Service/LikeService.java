/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;

import model.Like;

/**
 * @author kevinbusch
 *
 */
public class LikeService extends AbstractService{
	public void createLikes() {
		Like l1 = new Like();
		em.getTransaction().begin();
		em.persist(l1);
		em.getTransaction().commit();
		}
	@SuppressWarnings("unchecked")
	public void showAllLikes() {
		Query query = em.createNamedQuery("findAllLikes");
		List<Like> lk = query.getResultList();
		for (Like like : lk) {
			System.out.println(like);
		}
	}

}
