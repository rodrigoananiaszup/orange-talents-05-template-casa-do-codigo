package br.zupacademy.rodrigoananias.casadocodigo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.zupacademy.rodrigoananias.casadocodigo.Autor.Autor;
import br.zupacademy.rodrigoananias.casadocodigo.Categoria.Categoria;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.ExistId;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueValue;

public class LivroDto {

	//ATRIBUTOS
		@NotBlank
		@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Titulo deve ser único!")
		private String titulo;

		@NotBlank
		@Size(max = 500)
		private String resumo;

		private String sumario;

		@NotNull
		@Min(20)
		private BigDecimal preco;

		@NotNull
		@Min(100)
		private Integer paginas;

		@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN deve ser único!")
		private String isbn;

		@NotNull
		@Future
		@JsonIgnoreProperties ( value = {"dataPublicacao"}, ignoreUnknown = true , allowSetters = true ) 
		@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
		private LocalDate dataPublicacao;

		@ManyToOne
		@NotNull
		@ExistId(domainClass = Categoria.class, fieldName = "id")
		private Long idCategoria;

		@ManyToOne
		@NotNull
		@ExistId(domainClass = Autor.class, fieldName = "id")
		private Long idAutor;

		@Deprecated
		public LivroDto() {}


		//CONSTRUTOR
		@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
		public LivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
				@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer paginas, String isbn,
				@NotBlank @Future LocalDate dataPublicacao, @NotBlank Long idCategoria, @NotBlank Long idAutor) {
			this.titulo = titulo;
			this.resumo = resumo;
			this.sumario = sumario;
			this.preco = preco;
			this.paginas = paginas;
			this.isbn = isbn;
			this.dataPublicacao = dataPublicacao;
			this.idCategoria = idCategoria;
			this.idAutor = idAutor;
		}


		//GETTERS E SETTERS


		//SOBRESCRITA
		
		public Livro toModel(EntityManager em) {
			@NotNull
			Autor autor = em.find(Autor.class, this.idAutor);
			@NotNull
			Categoria categoria = em.find(Categoria.class, this.idCategoria);

			Assert.state(autor != null,
					"Você está querendo cadastrar um livro para um autor que não existe no banco: " + this.idAutor);
			Assert.state(categoria != null,
					"Você está querendo cadastrar um livro para uma categoria que não existe no banco: "
							+ this.idCategoria);

			return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn,
					this.dataPublicacao, categoria, autor);
		}

}
