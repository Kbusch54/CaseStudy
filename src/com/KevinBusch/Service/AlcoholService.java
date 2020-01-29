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

}
