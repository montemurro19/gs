package br.com.fiap.gs.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name="USUARIO")
@SequenceGenerator(sequenceName = "SQ_USUARIO", name="usuario", allocationSize = 1)
public class Usuario implements UserDetails {

	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Integer codigo;
	
	@NotBlank(message = "Nome é obrigatorio")
	@Column(name="NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name="TELEFONE", length = 50)
	private String telefone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Calendar dtNascimento;
	
	@NotBlank(message = "Email é obrigatorio")
	@Column(name="EMAIL", length = 50, nullable = false, unique=true)
	private String email;
	
	@NotBlank(message = "Senha é obrigatorio")
	@Column(name="SENHA", length = 100, nullable = false)
	private String senha;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao", nullable = false, updatable = false)
	private Calendar dtCadastro;
		
	@OneToOne(mappedBy = "usuario")
	private UsuarioDocumento usuarioDocumento;	
	
	@OneToOne(mappedBy = "usuario")
	private UsuarioEndereco usuarioEndereco;	
	
	public Usuario() {}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String nome, String telefone, Calendar dtNascimento, String email, String senha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.senha = senha;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
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
	
	public void setUsuarioDocumento(UsuarioDocumento usuarioDocumento) {
		this.usuarioDocumento = usuarioDocumento;
	}


	public void setUsuarioEndereco(UsuarioEndereco usuarioEndereco) {
		this.usuarioEndereco = usuarioEndereco;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_USUARIO");
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
