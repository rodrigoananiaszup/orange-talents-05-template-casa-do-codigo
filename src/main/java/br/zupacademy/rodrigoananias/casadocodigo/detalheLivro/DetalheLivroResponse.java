package br.zupacademy.rodrigoananias.casadocodigo.detalheLivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.zupacademy.rodrigoananias.casadocodigo.Livro.Livro;

public class DetalheLivroResponse {

	private DetalheAutorResponse autor;
	private String titulo;
	private String isbn;
	private Integer paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataPublicacao;

	@Deprecated
	public DetalheLivroResponse() {
	}

	public DetalheLivroResponse(Livro livro) {

		titulo = livro.getTitulo();
		autor = new DetalheAutorResponse(livro.getIdAutor());
		isbn = livro.getIsbn();
		paginas = livro.getPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

}
