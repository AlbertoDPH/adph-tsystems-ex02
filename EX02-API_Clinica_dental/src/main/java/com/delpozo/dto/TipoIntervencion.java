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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_intervenciones") // en caso que la tabala sea diferente
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoIntervencion {

	// Atributos de entidad tipoIntervencion
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "duracion_estimada", nullable = false)
	private int duracionEstimada;

	@OneToMany(mappedBy = "tipoIntervencion", fetch = FetchType.LAZY)
	private List<Cita> citas;

	// Constructores

	public TipoIntervencion() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param duracionEstimada
	 * @param citas
	 */
	public TipoIntervencion(int id, String nombre, String descripcion, int duracionEstimada, List<Cita> citas) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionEstimada = duracionEstimada;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
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
		return "TipoIntervencion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", duracionEstimada=" + duracionEstimada + ", citas=" + citas + "]";
	}

}
