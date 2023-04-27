package com.delpozo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
/**
 * Clase Cita
 * @author Alberto
 *
 */
@Entity
@Table(name = "citas") // en caso que la tabla sea diferente
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cita {

	// Atributos de la entidad cita
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Relacion de muchos a uno entre las entidades Cita y TipoIntervencion
	 * anotacion fetch = FetchType.LAZY hace que las intacias relacionas se cargen
	 * mediante sus respectivos getters
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	
	/**
	 *  Indica la columna en la tabla de la bbdd que se usa para establecer la relacion
	 *  entre las entidades
	 */
	@JoinColumn(name = "id_tipo_intervencion")
	private TipoIntervencion tipoIntervencion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dentista")
	private Dentista dentista;

	/**
	 * Establece la fecha y hora e indica que no puede tener valores nulos
	 * cada cita tendra uan fecha y hora validas.
	 */
	@Column(name = "fecha_hora", nullable = false)
	private LocalDateTime fechaHora;

	// Constructores

	public Cita() {

	}

	public Cita(int id, TipoIntervencion tipoIntervencion, Cliente cliente, Dentista dentista, LocalDateTime fechaHora) {
		this.id = id;
		this.tipoIntervencion = tipoIntervencion;
		this.cliente = cliente;
		this.dentista = dentista;
		this.fechaHora = fechaHora;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoIntervencion getTipoIntervencion() {
		return tipoIntervencion;
	}

	public void setTipoIntervencion(TipoIntervencion tipoIntervencion) {
		this.tipoIntervencion = tipoIntervencion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Cita [id=" + id + ", tipoIntervencion=" + tipoIntervencion + ", cliente=" + cliente + ", dentista="
				+ dentista + ", fechaHora=" + fechaHora + "]";
	}

}
