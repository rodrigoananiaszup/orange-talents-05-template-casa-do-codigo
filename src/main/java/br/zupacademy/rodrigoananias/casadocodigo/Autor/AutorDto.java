package br.zupacademy.rodrigoananias.casadocodigo.Autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueValue;

//Classe que realiza a requisição
public class AutorDto {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "O e-mail deve ser unico")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	// construtor

	public AutorDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	// metodos Getters e Setters

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
