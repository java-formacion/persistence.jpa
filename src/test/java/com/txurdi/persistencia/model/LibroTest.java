package com.txurdi.persistencia.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {
	

	static ValidatorFactory factory;
	static Validator validator;
	
	static Editorial editorialMock = null;
	static Libro libroMock = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {		
		factory = null;
		validator = null;		
	}

	@Before
	public void setUp() throws Exception {
		editorialMock = new Editorial(1, "Alfaguara");
		libroMock = new Libro("El libro de la selva", editorialMock);
	}

	@After
	public void tearDown() throws Exception {
		editorialMock = null;
		libroMock = null;
	}

	@Test
	public void testLibroOk() {
	
		Set<ConstraintViolation<Libro>> constrains = validator.validate(libroMock);
		assertTrue("El libro deberia ser valido", constrains.isEmpty());
		
	}
	
	@Test
	public void testLibroNotOk() {
		
		//null
		libroMock.setNombre(null);
		Set<ConstraintViolation<Libro>> constrains = validator.validate(libroMock);
		assertFalse("El libro NO deberia ser valido, nombre = null ", constrains.isEmpty());
				
		// 1 letra
		libroMock.setNombre("a");
		constrains = validator.validate(libroMock);
		assertFalse("El libro NO deberia ser valido, nombre solo una letra", constrains.isEmpty());
		assertTrue("solo debe existir una constrains", constrains.size() == 1 );
		
		for ( ConstraintViolation<Libro> constraint : constrains) {						
			assertEquals("nombre", constraint.getPropertyPath().toString() );
			assertEquals("El nombre debe estar entre 2 y 255 caracteres", constraint.getMessage() );
		}
					
		// 2 letras
		libroMock.setNombre("ab");
		constrains = validator.validate(libroMock);
		assertTrue("El libro deberia ser valido, nombre dos letras", constrains.isEmpty());
		
		
		/*  TODO resto de casos
		
		// 255 letras
		
		// 256 letras
		
		
		*/
		
	}

}
