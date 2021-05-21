package br.zupacademy.rodrigoananias.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	//Encapsulamento dos dados
	@PersistenceContext
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid ClienteDto clienteDto) {
		Cliente cliente = clienteDto.toModel(em);

		em.persist(cliente);

		return cliente.toString();

	}

}
