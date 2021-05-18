package br.zupacademy.rodrigoananias.casadocodigo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	//ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
		@PersistenceContext
		private EntityManager em;
		
		//REQUISIÇÃO PARA SALVAR UMA NOVA CATEGORIA
		@PostMapping
		@Transactional
		public String cadastrar(@RequestBody @Valid CategoriaDto categoriaDto) {
			Categoria categoria = categoriaDto.toModel();
			em.persist(categoria);
			return categoria.toString();
		}
}
