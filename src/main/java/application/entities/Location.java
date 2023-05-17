package application.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String città;

	public Location(String nome, String città) {
		super();
		this.nome = nome;
		this.città = città;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", città=" + città + "]";
	}

}
