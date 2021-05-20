package br.zupacademy.rodrigoananias.casadocodigo.Livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	// ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LivroRepository livroRepository;

	// REQUISIÇÃO PARA SALVAR UM NOVO LIVRO
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroDto livroDto) {

		Livro livro = livroDto.toModel(em);

		em.persist(livro);

		return livro.toString();
	}

	// Acessar livros cadastrados
	@GetMapping
	public ResponseEntity<Iterable<Livro>> listar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getById(@PathVariable Long id) {
		return livroRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

}
