package application.DAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import application.entities.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location l) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(l);
		transaction.commit();
		log.info("Location salvata!");

	}

	public Location getById(UUID id) {

		Location found = em.find(Location.class, id);
		return found;
	}

	public void delete(UUID id) {
		Location found = em.find(Location.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Location con id " + id + " eliminata!");
		} else {
			log.info("Location con id " + id + " non trovata!");
		}
	}
}
