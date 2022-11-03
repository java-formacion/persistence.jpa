package com.txurdi.persistencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity                       // @Entity define que la entidad es persistible contra la base de datos
@Table(name = "libros")


@NamedQuery(query = "SELECT l FROM Libro l WHERE l.id = :id", name = "find libro by id")

public class Libro  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	
	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
	}

	public Libro(String nombre) {
		this();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + "]";
	}
	

}
