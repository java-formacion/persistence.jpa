package com.txurdi.persistencia.ejemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.persistencia.model.Editorial;

public class EjemploEditorial {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Editorial e1 = new Editorial("Barco de Vapor");
		Editorial e2 = new Editorial("Alfaguarra");
		
		em.persist(e1);
		em.persist(e2);
		
		
		em.getTransaction().commit();
		em.close();
		
	}

}
