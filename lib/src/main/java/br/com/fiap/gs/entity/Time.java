package br.com.fiap.gs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="TIME")
@SequenceGenerator(sequenceName = "SQ_TIME", name="time", allocationSize = 1)
public class Time {

	@Id
	@Column(name="ID_TIME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time")
	private Integer codigo;

	@NotBlank(message = "Nome é obrigatorio")
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@NotBlank(message = "Privacidade é obrigatorio")
	@Column(name="PRIVACIDADE", length = 50, nullable = false)
	private String privacidade;

	@NotBlank(message = "Região de atuação é obrigatorio")
	@Column(name="REGIAO_ATUACAO", length = 50, nullable = false)
	private String regiaoAtuacao;
	
	@NotBlank(message = "Descrição é obrigatorio")
	@Column(name="DESCRICAO", length = 500, nullable = false)
	private String descricao;

	public Time() {}
	
	public Time(String nome, String privacidade, String regiaoAtuacao, String descricao) {
		super();
		this.nome = nome;
		this.privacidade = privacidade;
		this.regiaoAtuacao = regiaoAtuacao;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(String privacidade) {
		this.privacidade = privacidade;
	}

	public String getRegiaoAtuacao() {
		return regiaoAtuacao;
	}

	public void setRegiaoAtuacao(String regiaoAtuacao) {
		this.regiaoAtuacao = regiaoAtuacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
