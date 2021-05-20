package br.zupacademy.rodrigoananias.casadocodigo.detalheLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.zupacademy.rodrigoananias.casadocodigo.Livro.Livro;

@RestController
@RequestMapping("/produtos")
public class DetalheLivroController {

	@PersistenceContext
	private EntityManager em;

	@GetMapping("/{id}")
	public ResponseEntity<?> detalhar(@PathVariable Long id) {

		Livro buscaLivro = em.find(Livro.class, id);

		if (buscaLivro == null) {
			return ResponseEntity.notFound().build();
		}

		DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(buscaLivro);

		return ResponseEntity.ok(detalheLivroResponse);
	}
}
