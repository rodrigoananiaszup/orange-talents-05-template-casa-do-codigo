package br.zupacademy.rodrigoananias.casadocodigo.Categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueValue;

//Classe que realiza a requisição
public class CategoriaDto {

	// ATRIBUTOS
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome da categoria deve ser único!")
	private String nome;

	@Deprecated
	public CategoriaDto() {
	}

	// CONSTRUTOR
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDto(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
