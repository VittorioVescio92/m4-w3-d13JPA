package application.DAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import application.entities.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		log.info("Evento salvato!");

	}

	public Persona getById(UUID id) {

		Persona found = em.find(Persona.class, id);
		return found;
	}

	public void delete(UUID id) {
		Persona found = em.find(Persona.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Persona con id " + id + " eliminata!");
		} else {
			log.info("Persona con id " + id + " non trovata!");
		}
	}

}
