package com.delpozo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas") // en caso que la tabla sea diferente
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cita {

	// Atributos de la entidad cita
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_intervencion")
	private TipoIntervencion tipoIntervencion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dentista")
	private Dentista dentista;

	@Column(name = "fecha_hora", nullable = false)
	private LocalDateTime fechaHora;

	@Column(name = "descripcion", columnDefinition = "TEXT")
	private String descripcion;

	// Constructores

	public Cita() {

	}

	public Cita(int id, TipoIntervencion tipoIntervencion, Cliente cliente, Dentista dentista, LocalDateTime fechaHora,
			String descripcion) {
		this.id = id;
		this.tipoIntervencion = tipoIntervencion;
		this.cliente = cliente;
		this.dentista = dentista;
		this.fechaHora = fechaHora;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Cita [id=" + id + ", tipoIntervencion=" + tipoIntervencion + ", cliente=" + cliente + ", dentista="
				+ dentista + ", fechaHora=" + fechaHora + ", descripcion=" + descripcion + "]";
	}

}
