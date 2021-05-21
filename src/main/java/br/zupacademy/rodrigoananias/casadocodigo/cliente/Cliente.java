package br.zupacademy.rodrigoananias.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.zupacademy.rodrigoananias.casadocodigo.paisestado.Estado;
import br.zupacademy.rodrigoananias.casadocodigo.paisestado.Pais;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;

	@NotBlank
	@Column(unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@NotNull
	@ManyToOne
	private Pais pais;

	//MUITOS CLIENTES PARA UM ESTADO
	@ManyToOne
	private Estado estado;

	@Deprecated
	public Cliente() {
	}

	// CONSTRUTOR
	public Cliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, Pais pais,
			@NotBlank String telefone, @NotBlank String cep) {

		this.email = email;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;

	}

	// GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// SOBESCRITA DE METODO
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", pais=" + pais
				+ ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}
