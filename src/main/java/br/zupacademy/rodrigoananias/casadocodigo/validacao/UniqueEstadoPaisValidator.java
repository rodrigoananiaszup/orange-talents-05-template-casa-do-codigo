package br.zupacademy.rodrigoananias.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class UniqueEstadoPaisValidator implements ConstraintValidator<UniqueEstadoPais, Object> {

	@PersistenceContext
	EntityManager em;

	private String fieldName1;
	private String fieldName2;
	private Class<?> cClass;

	@Override
	public void initialize(UniqueEstadoPais uniqueEstadoPais) {
		fieldName1 = uniqueEstadoPais.fieldName1();
		fieldName2 = uniqueEstadoPais.fieldName2();
		cClass = uniqueEstadoPais.domainClass();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query = em.createQuery(
				"SELECT 1 FROM " + cClass.getName() + " c WHERE " + fieldName1 + 
				"=:nome AND c.pais.id =:idPais");

		String nome = (String) new BeanWrapperImpl(value).getPropertyValue(fieldName1);

		query.setParameter("nome", nome);

		Long idPais = (Long) new BeanWrapperImpl(value).getPropertyValue(fieldName2);
		query.setParameter("idPais", idPais);
		return query.getResultList().isEmpty();
	}
}
