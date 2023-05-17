package application.DAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import application.entities.Partecipazione;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartecipazioneDAO {
	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		log.info("Partecipazione salvata!");

	}

	public Partecipazione getById(UUID id) {

		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void delete(UUID id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Partecipazione con id " + id + " eliminata!");
		} else {
			log.info("Partecipazione con id " + id + " non trovata!");
		}
	}

	public void update(Partecipazione p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(p);
		transaction.commit();
		log.info("Partecipazione con id " + p.getId() + " aggiornata!");
	}
}
