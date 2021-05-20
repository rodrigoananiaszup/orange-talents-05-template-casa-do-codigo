package br.zupacademy.rodrigoananias.casadocodigo.paisestado;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank
		private String nome;

		//relacionamento - um pais para varios estados
		@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
		private List<Estado> estados;

		@Deprecated
		public Pais() {
		}

		//construtor
		public Pais(@NotBlank String nome) {
			this.nome = nome;
		}

		//SOBESCRITA
		@Override
		public String toString() {
			return "Pais [id=" + id + ", nome=" + nome + "]";
		}

		//GETTERS E SETTERS
		public String getNome() {
			return nome;
		}

		public List<Estado> getEstados() {
			return estados;
		}
}
