package com.delpozo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dentistas") // en caso que la tabala sea diferente
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dentista {

	// Atributos de entidad dentista
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "especialidad")
	private String especialidad;

	@OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
	private List<Cita> citas;

	// Constructores

	public Dentista() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param contrasena
	 * @param especialidad
	 * @param citas
	 */
	public Dentista(int id, String nombre, String apellido, String email, String contrasena, String especialidad,
			List<Cita> citas) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.especialidad = especialidad;
		this.citas = citas;
	}

	// Getters y Setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Cita")
	public List<Cita> getCita() {
		return citas;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Dentista [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasena=" + contrasena + ", especialidad=" + especialidad + ", citas=" + citas + "]";
	}

}
