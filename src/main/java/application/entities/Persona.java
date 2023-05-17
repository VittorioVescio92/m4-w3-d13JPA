package application.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persone")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	@Column(name = "data_di_nascita")
	private LocalDate dataDiNascita;

	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private Set<Partecipazione> listaPartecipazioni;

	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			Set<Partecipazione> listaPartecipazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataDiNascita="
				+ dataDiNascita + ", sesso=" + sesso + "]";
	}

}
