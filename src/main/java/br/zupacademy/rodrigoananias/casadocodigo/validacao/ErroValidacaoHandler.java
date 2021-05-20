package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class,})
    public List<ErroValidacao> handle(MethodArgumentNotValidException exception) {

        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();

        List<ErroValidacao> validacaoErros = new ArrayList<>();

        fieldError.forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            ErroValidacao validacaoErro = new ErroValidacao(erro.getField(), mensagem);

            validacaoErros.add(validacaoErro);
        });

        return validacaoErros;

    }

}