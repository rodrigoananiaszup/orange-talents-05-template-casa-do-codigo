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
@RequestMapping("/pais")
public class PaisController {

	//ENCAPSULA NOSSOS DADOS QUE SERÃO SALVOS
	@PersistenceContext
	private EntityManager em;
	
	//REQUISIÇÃO PARA SALVAR UM NOVO PAÍS
	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid PaisDto paisDto) {
		
		Pais mypais = paisDto.toModel();
		
		em.persist(mypais);
		
		return mypais.toString();
	}

}
