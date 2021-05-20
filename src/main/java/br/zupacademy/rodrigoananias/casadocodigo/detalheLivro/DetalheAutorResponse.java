package br.zupacademy.rodrigoananias.casadocodigo.detalheLivro;

import br.zupacademy.rodrigoananias.casadocodigo.Autor.Autor;

public class DetalheAutorResponse {
	
	private String nome;
	private String descricao;
	
	//construtor
	@Deprecated
	public DetalheAutorResponse() {}
	
	public DetalheAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	
	//getters
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

	

}
