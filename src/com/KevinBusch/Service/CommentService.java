/**
 * 
 */
package com.KevinBusch.Service;

import java.util.List;

import javax.persistence.Query;

import model.Comment;

/**
 * @author kevinbusch
 *
 */
public class CommentService extends AbstractService{
	public void createComment() {
		Comment c1 = new Comment();
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		}
	@SuppressWarnings("unchecked")
	public void showAllComments() {
		Query query = em.createNamedQuery("findAllComment");
		List<Comment> com = query.getResultList();
		for (Comment comment : com) {
			System.out.println(comment);
		}
	}

}
