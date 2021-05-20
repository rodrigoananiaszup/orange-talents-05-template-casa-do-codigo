package br.zupacademy.rodrigoananias.casadocodigo.Livro.execao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MinhaExcecao {

	public MinhaExcecao(String error) {
		super();
	}
	
}
