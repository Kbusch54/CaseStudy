/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;

import model.Alcohol;

/**
 * @author kevinbusch
 *
 */
public class AlcoholService extends AbstractService{
	public void createAlcohol() {
		Alcohol a1 = new Alcohol();
		em.getTransaction().begin();
		em.persist(a1);
		em.getTransaction().commit();
		}
	public void showAllAlcohol() {
		Query query = em.createNamedQuery("findAllAlc");
		@SuppressWarnings("unchecked")
		List<Alcohol> alcohol = query.getResultList();
		for (Alcohol alc : alcohol) {
			System.out.println(alc);
		}
	}
	@SuppressWarnings("unchecked")
	public void showAlcoholByUserId(Long userId) {
		Query query = em.createQuery("Select a from Alcohol a where a.userId = :userid");
		query.setParameter("userId", userId);
		List<Alcohol> alc = query.getResultList();
		for (Alcohol alcohol : alc) {
			System.out.println(alcohol);
		}
	}
	@SuppressWarnings("unchecked")
	public void showAllByType(String type) {
		Query query = em.createQuery("SELECT a FROM Alcohol a where a.type = :type");
		query.setParameter("type", type);
		List<Alcohol> alc = query.getResultList();
		for (Alcohol alcohol : alc) {
			System.out.println(alcohol);
		}
	}

}
