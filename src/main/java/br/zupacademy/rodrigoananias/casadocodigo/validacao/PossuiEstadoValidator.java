package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.zupacademy.rodrigoananias.casadocodigo.cliente.ClienteDto;
import br.zupacademy.rodrigoananias.casadocodigo.paisestado.Pais;

@Component
public class PossuiEstadoValidator implements Validator {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean supports(Class<?> cClass) {
		return ClienteDto.class.isAssignableFrom(cClass);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ClienteDto clienteDto = (ClienteDto) object;

		Pais pais = em.find(Pais.class, clienteDto.getIdPais());

		boolean naoPossuiEstado = pais.getEstados().isEmpty();

		if (!naoPossuiEstado && clienteDto.getIdEstado() == null) {
			errors.rejectValue("idEstado", null,
					"Esse País possui Estado, dessa forma devera escolher um Estado para finalizar!");
		}
	}

}
