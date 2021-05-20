package br.zupacademy.rodrigoananias.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.zupacademy.rodrigoananias.casadocodigo.validacao.ExistId;
import br.zupacademy.rodrigoananias.casadocodigo.validacao.UniqueEstadoPais;

//classe para request
@UniqueEstadoPais(domainClass = Estado.class, fieldName1 = "nome", fieldName2 = "idPais")
public class EstadoDto {

	// ATRIBUTOS
	@NotBlank
	private String nome;

	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id", message = "Este Pais não existe!")
	private Long idPais;

	@Deprecated
	public EstadoDto() {}

	// CONSTRUTOR
	public EstadoDto(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	// getters
	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	// SOBRESCRITA
    public Estado toModel(EntityManager em){
        Pais pais = em.find(Pais.class,this.idPais);
        return new Estado(this.nome,pais);
    }
	
}
