package br.com.fiap.gs.entity;

import java.util.Calendar;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
@Table(name="EMPRESA")
@SequenceGenerator(sequenceName = "SQ_EMPRESA", name="empresa", allocationSize = 1)
public class Empresa {

	@Id
	@Column(name="ID_EMPRESA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	private Integer codigo;
	
	@NotBlank(message = "Razão social é obrigatorio")
	@Column(name="RAZAO_SOCIAL", length = 50, nullable = false)
	private String razaoSocial;
	
	@NotBlank(message = "CNPJ é obrigatorio")
	@Column(name="CNPJ", length = 50, nullable = false)
	private String cnpj;

	@Column(name="TELEFONE", length = 50)
	private String telefone;
	
	@NotBlank(message = "Email é obrigatorio")
	@Column(name="EMAIL", length = 50, nullable = false, unique=true)
	private String email;
	
	@NotBlank(message = "Senha é obrigatorio")
	@Column(name="SENHA", length = 50, nullable = false)
	private String senha;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao", nullable = false, updatable = false)
	private Calendar dtCadastro;

	@OneToOne(mappedBy = "empresa")
	private EmpresaEndereco empresaEndereco;	

	public Empresa () {}
	
	public Empresa(String razaoSocial, String cnpj, String telefone, String email, String senha) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
