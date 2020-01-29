/**
 * 
 */
package com.KevinBusch.Service;



import java.util.List;

import javax.persistence.Query;

import model.Account;

/**
 * @author kevinbusch
 *
 */
public class AccountService extends AbstractService {

	public void createAccount() {
		Account a1 = new Account();
		em.getTransaction().begin();
		em.persist(a1);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public void showAllAccounts() {
		Query query = em.createNamedQuery("findAllAcc");
		List<Account> acc = query.getResultList();
		for (Account account : acc) {
			System.out.println(account);
		}
	}
	@SuppressWarnings("unchecked")
	public void  showAccBio(String userName) {
		Query query = em.createNamedQuery("accBioPage");
		query.setParameter("userName", userName);
		List<Account> acc = query.getResultList();
		for (Account account : acc) {
			System.out.println(account);
		}
		
	}

}
