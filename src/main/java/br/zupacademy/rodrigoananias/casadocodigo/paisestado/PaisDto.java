package br.zupacademy.rodrigoananias.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueValue;

public class PaisDto {

	// ATRIBUTOS
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O nome do Pais deve ser Unico!")
	private String nome;

	@Deprecated
		public PaisDto() {}

	// CONSTRUTOR
	public PaisDto(@NotBlank String nome) {
			this.nome = nome;
		}

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	// SOBRESCRITA
	public Pais toModel() {
		return new Pais(this.nome);
	}

}
