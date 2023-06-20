package com.joyfe.naruto.des.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Personajes {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id_personaje;
	@NotBlank(message = "Tiene que tener un nombre")
	private String nombre;
	private int edad;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_clan")
	private Clan clan;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_villa")
	private Villas villas;
	@JoinTable(
		       name = "rel_personajes_elemento",
		       joinColumns = @JoinColumn(name = "fk_personaje", nullable = false),
		       inverseJoinColumns = @JoinColumn(name="fk_elemento", nullable = false)
		   )
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Elementos> elementos;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_organizacion")
	private Organizaciones organizaciones;
	
	public enum Estado{
		Vivo, 
		Muerto
	}
	
	public Personajes() {
		super();
	}

	public Personajes(String nombre, int edad, Estado estado, Clan clan, Villas villas, List<Elementos> elementos, Organizaciones organizaciones) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.estado = estado;
		this.clan = clan;
		this.villas = villas;
		this.elementos = elementos;
		this.organizaciones = organizaciones;
	}

	public long getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(long id_personaje) {
		this.id_personaje = id_personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Villas getVillas() {
		return villas;
	}

	public void setVillas(Villas villas) {
		this.villas = villas;
	}

	public Organizaciones getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(Organizaciones organizaciones) {
		this.organizaciones = organizaciones;
	}
	public List<Elementos> getElementos() {
		return elementos;
	}

	public void setElementos(List<Elementos> elementos) {
		this.elementos = elementos;
	}
	
	
}
