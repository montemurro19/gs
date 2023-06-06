package br.com.fiap.gs.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="TIME_REGISTRO")
@SequenceGenerator(sequenceName = "SQ_TIME_REGISTRO", name="registro", allocationSize = 1)
public class TimeRegistro {

	@Id
	@Column(name="ID_Registro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ong")
	private Integer codigo;

	@Column(name="ATIVO", length = 100)
	private String ativo;
	
	@ManyToMany(mappedBy = "registro")
	private List<ONG> ong;

	public TimeRegistro() {}
	
	public TimeRegistro(String ativo) {
		this.ativo = ativo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public List<ONG> getOng() {
		return ong;
	}

	public void setOng(List<ONG> ong) {
		this.ong = ong;
	}
}
