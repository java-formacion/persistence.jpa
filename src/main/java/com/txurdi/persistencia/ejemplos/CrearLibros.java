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

	public static void main(String[] args) throws Exception {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		Libro libro = new Libro("Dime quien soy");
		Libro libro2 = new Libro("El libro de la selva");
		Libro libro3 = new Libro("Papillom");
		
		em.persist(libro);
		em.persist(libro2);
		
		/*
		if ( true ) {
			throw new Exception("Excepcion lanzada a proposito, No deberia guardarse ningun Libro en la bbdd");
		}
		*/	
		
		em.persist(libro3);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		

	}

}
