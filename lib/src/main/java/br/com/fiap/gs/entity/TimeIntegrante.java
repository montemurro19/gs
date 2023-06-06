package br.com.fiap.gs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="TIME_INTEGRANTE")
@SequenceGenerator(sequenceName = "SQ_TIME_INTEGRANTE", name="integrante", allocationSize = 1)
public class TimeIntegrante {

	@Id
	@Column(name="ID_INTEGRANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ong")
	private Integer codigo;

	@NotBlank(message = "Cargo é obrigatorio")
	@Column(name="CARGO", length = 100, nullable = false)
	private String cargo;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Time time;

	public TimeIntegrante () {}
	
	public TimeIntegrante(String cargo) {
		this.cargo = cargo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
