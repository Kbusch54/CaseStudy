/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;

import model.Tag;

/**
 * @author kevinbusch
 *
 */
public class TagService extends AbstractService{
	public void createTag() {
		Tag t1 = new Tag();
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
		}
	@SuppressWarnings("unchecked")
	public void showAllTags() {
		Query query = em.createNamedQuery("findAllTags");
		List<Tag> tag = query.getResultList();
		for (Tag t : tag) {
			System.out.println(t);
		}
	}

}
