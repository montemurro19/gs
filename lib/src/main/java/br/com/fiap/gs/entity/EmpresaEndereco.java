package br.com.fiap.gs.entity;

import jakarta.persistence.*;

@Entity
@Table(name="EMPRESA_ENDERECO")
@SequenceGenerator(sequenceName = "SQ_EMPRESA_ENDERECO", name="empresaEnd", allocationSize = 1)
public class EmpresaEndereco {

	@Id
	@Column(name="ID_EMPRESA_END")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresaEnd")
	private Integer codigo;

	@Column(name="CEP", length = 50)
	private String cep;
	
	@Column(name="LOGRADOURO", length = 500)
	private String logradouro;
	
	@Column(name="BAIRRO", length = 100)
	private String bairro;
	
	@Column(name="CIDADE", length = 100)
	private String cidade;
	
	@Column(name="ESTADO", length = 100)
	private String estado;
	
	@Column(name="NUMERO", length = 5)
	private String numero;
	
	@Column(name="COMPLEMENTO", length = 200)
	private String complemento;
	
	@ManyToOne
	private Empresa empresa;
	
	public EmpresaEndereco() {}

	public EmpresaEndereco(String cep, String logradouro, String bairro, String cidade, String estado, String numero,
			String complemento) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
