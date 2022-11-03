package com.txurdi.persistencia.ejemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.persistencia.model.Libro;



/**
 * Ejemplo para crear Libros mediante el EntityManager
 * @author ander
 *
 */
public class CrearLibros {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		Libro libro = new Libro("Dime quien soy");
		Libro libro2 = new Libro("El libro de la selva");
		
		em.persist(libro);
		em.persist(libro2);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		

	}

}
