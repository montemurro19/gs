package br.com.fiap.gs.entity;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

@Entity
@Table(name="ONG")
@SequenceGenerator(sequenceName = "SQ_ONG", name="ong", allocationSize = 1)
public class ONG {

	@Id
	@Column(name="ID_ONG")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ong")
	private Integer codigo;

	@NotBlank(message = "Nome é obrigatorio")
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@NotBlank(message = "Região de atuação é obrigatorio")
	@Column(name="REGIAO_ATUACAO", length = 50, nullable = false)
	private String regiaoAtuacao;
	
	@NotBlank(message = "Descrição é obrigatorio")
	@Column(name="DESCRICAO", length = 500, nullable = false)
	private String descricao;
	
	@OneToOne
	private Empresa empresa;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="TB_REGISTRO_ONG", 
			joinColumns = @JoinColumn(name="ONG_ID"),
			inverseJoinColumns = @JoinColumn(name="Registro_ID"))
	private List<TimeRegistro> registro;

	public ONG(String nome, String regiaoAtuacao, String descricao) {
		super();
		this.nome = nome;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
