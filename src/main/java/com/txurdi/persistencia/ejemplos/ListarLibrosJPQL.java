package com.txurdi.persistencia.ejemplos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.persistencia.model.Libro;



/**
 * Ejemplo para crear Libros mediante el Java Persistence Query Language
 * Sintaxis JPQL es muy similar a la sintaxis de SQL. 
 * Tener SQL como sintaxis es una ventaja porque SQL es simple y siendo ampliamente utilizado.
 * SQL trabaja directamente contra la base de datos relacional tablas, registros y campos, mientras que JPQL trabaja con Java clases e instancias.
 * 
 * @author ander
 * @see https://www.tutorialspoint.com/es/jpa/jpa_jpql.htm
 *
 */
public class ListarLibrosJPQL {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		
		// no hace falta transacciones
		//em.getTransaction().begin();
				
		
		ArrayList<Libro> libros = (ArrayList<Libro>) em.createQuery("SELECT l FROM Libro l").getResultList();		
		System.out.println(libros);
		
		em.close();
			

	}

}
