package br.zupacademy.rodrigoananias.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.zupacademy.rodrigoananias.casadocodigo.paisestado.Estado;
import br.zupacademy.rodrigoananias.casadocodigo.paisestado.Pais;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.CPFouCNPJ;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.ExistId;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueValue;

public class ClienteDto {

	//atributos da classe ClienteDto
		@Email
		@UniqueValue(domainClass = Cliente.class, fieldName = "email")
		private String email;

		@NotBlank
		private String nome;

		@NotBlank
		private String sobrenome;

		@NotBlank
		@CPFouCNPJ
		@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
		private String documento;

		@NotBlank
		private String endereco;

		@NotBlank
		private String complemento;

		@NotBlank
		private String cidade;

		@NotNull
		@ExistId(domainClass = Pais.class, fieldName = "id")
		private Long idPais;

		@ExistId(domainClass = Estado.class, fieldName = "id")
		private Long idEstado;

		@NotBlank
		private String telefone;

		@NotBlank
		private String cep;

		@Deprecated
		public ClienteDto() {
		}

		//metodo construtor da classe
		public ClienteDto(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
				@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
				@NotBlank String cidade, Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
			this.email = email;
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.documento = documento;
			this.endereco = endereco;
			this.complemento = complemento;
			this.cidade = cidade;
			this.idPais = idPais;
			this.idEstado = idEstado;
			this.telefone = telefone;
			this.cep = cep;
		}

		//getters
		public String getEmail() {
			return email;
		}

		public String getNome() {
			return nome;
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

		public Long getIdPais() {
			return idPais;
		}

		public Long getIdEstado() {
			return idEstado;
		}

		public String getTelefone() {
			return telefone;
		}

		public String getCep() {
			return cep;
		}

		//sobrescrita
		public Cliente toModel(EntityManager em) {
			Pais pais = em.find(Pais.class, idPais);
			Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
					this.complemento, this.cidade, pais, this.telefone, this.cep);
			if (idEstado != null) {
				cliente.setEstado(em.find(Estado.class, idEstado));
			}
			return cliente;
		}
}
