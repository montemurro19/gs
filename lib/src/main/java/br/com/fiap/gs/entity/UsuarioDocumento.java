package br.com.fiap.gs.entity;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIO_DOCUMENTO")
@SequenceGenerator(sequenceName = "SQ_USUARIO_DOCUMENTO", name="usuarioDoc", allocationSize = 1)
public class UsuarioDocumento {

	@Id
	@Column(name="ID_USUARIO_DOC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioDoc")
	private Integer codigo;
	
	@Column(name="ID_ESTRANGEIRO", length = 50)
	private String idEstrangeiro;
	
	@Column(name="CPF", length = 50)
	private String cpf;
	
	@Column(name="RG", length = 50)
	private String rg;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;	
	
	public UsuarioDocumento() {}
	
	public UsuarioDocumento(String idEstrangeiro, String cpf, String rg) {
		super();
		this.idEstrangeiro = idEstrangeiro;
		this.cpf = cpf;
		this.rg = rg;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getIdEstrangeiro() {
		return idEstrangeiro;
	}

	public void setIdEstrangeiro(String idEstrangeiro) {
		this.idEstrangeiro = idEstrangeiro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
