package br.zupacademy.rodrigoananias.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	//encapsulamento dos dados que vão ser persistidos
	@PersistenceContext
	private EntityManager em;
	
	
	//request para salvar um estado
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid EstadoDto estadoDto) {
		Estado estado = estadoDto.toModel(em);
		em.persist(estado);
		
		return estado.toString();
	}
}
