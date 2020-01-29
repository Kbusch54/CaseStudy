/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;


import model.Category;

/**
 * @author kevinbusch
 *
 */
public class CategoryService extends AbstractService{
	public void createCategory() {
		Category c1 = new Category();
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		}
	@SuppressWarnings("unchecked")
	public void showAllCategories() {
		Query query = em.createNamedQuery("findAllCategory");
		List<Category> cat = query.getResultList();
		for (Category category : cat) {
			System.out.println(category);
		}
	}

}
