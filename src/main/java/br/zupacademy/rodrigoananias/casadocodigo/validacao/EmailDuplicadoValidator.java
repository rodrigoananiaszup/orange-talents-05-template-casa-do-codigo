package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.zupacademy.rodrigoananias.casadocodigo.Autor.Autor;
import br.zupacademy.rodrigoananias.casadocodigo.Autor.AutorDto;
import br.zupacademy.rodrigoananias.casadocodigo.Autor.AutorRepository;

@Component
public class EmailDuplicadoValidator implements Validator {

	private AutorRepository autorRepository;

	public EmailDuplicadoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> cClass) {
		return AutorDto.class.isAssignableFrom(cClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorDto request = (AutorDto) o;
		Optional<Autor> optional = autorRepository.findByEmail(request.getEmail());
		if (optional.isPresent()) {
			errors.rejectValue("email", null, "O email informado possui registro: " + request.getEmail());
		}
	}
}