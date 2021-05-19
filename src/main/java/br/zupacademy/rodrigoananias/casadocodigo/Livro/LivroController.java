package br.zupacademy.rodrigoananias.casadocodigo.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	//ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
	@PersistenceContext
	private EntityManager em;
	
	
	//REQUISIÇÃO PARA SALVAR UM NOVO LIVRO
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroDto livroDto) {

		Livro livro = livroDto.toModel(em);
		
		em.persist(livro);
		
		return livro.toString();
	}

}
