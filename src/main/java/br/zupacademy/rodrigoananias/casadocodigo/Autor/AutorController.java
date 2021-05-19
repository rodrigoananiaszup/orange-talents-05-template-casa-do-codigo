package br.zupacademy.rodrigoananias.casadocodigo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	// Encapsulamento
	@PersistenceContext
	private EntityManager em;

	// Requisição realizada para inserir um autor
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid AutorDto autorDto) {
		Autor autor = autorDto.toModel();
		em.persist(autor);

		return autor.toString();
	}

}
