package com.joyfe.naruto.des.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Organizaciones {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id_organizacion;
	@NotBlank(message = "Escribe el nombre de la organización")
	private String nombre;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private int num_miembro;
	@OneToMany(mappedBy = "organizaciones")
	@JsonBackReference
	private List<Personajes> personajes;
	
	public enum Tipo{
		Criminal,
		Aldea
	}
	
public Organizaciones(){
		
		super();
	}
	
	public Organizaciones(String nombre, Tipo tipo){
		
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
public Organizaciones(String nombre){
		
		this.nombre = nombre;
	}

	public long getId_organizacion() {
		return id_organizacion;
	}

	public void setId_organizacion(long id_organizacion) {
		this.id_organizacion = id_organizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getNum_miembro() {
		return num_miembro;
	}

	public void setNum_miembro(int num_miembro) {
		this.num_miembro = num_miembro;
	}
	public List<Personajes> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personajes> personajes) {
		this.personajes = personajes;
	}

}
