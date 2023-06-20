package com.joyfe.naruto.des.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Elementos {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id_elemento;
	@NotBlank(message = "Tiene que tener un nombre")
	private String nombre;
	@NotBlank(message="Tiene que tener una caracteristica")
	private String caracteristicas;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "elementos")
	@JsonBackReference
	private List<Personajes> personajes;
	
public Elementos(){
		super();
	}
	
	public Elementos(String nombre, String caracteristicas){
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		}
	
	public Elementos(String nombre){
		
		this.nombre = nombre;
	}
	
	public long getId_elemento() {
		return id_elemento;
	}
	public void setId_elemento(long id_elemento) {
		this.id_elemento = id_elemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public List<Personajes> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personajes> personajes) {
		this.personajes = personajes;
	}
	
	
}
