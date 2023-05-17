package application;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.DAO.EventoDAO;
import application.DAO.LocationDAO;
import application.DAO.PartecipazioneDAO;
import application.DAO.PersonaDAO;
import application.entities.Evento;
import application.entities.Location;
import application.entities.Partecipazione;
import application.entities.Persona;
import application.entities.Sesso;
import application.entities.StatoPartecipazione;
import application.entities.TipoEvento;
import application.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);
		PersonaDAO pd = new PersonaDAO(em);
		LocationDAO ld = new LocationDAO(em);
		PartecipazioneDAO pd2 = new PartecipazioneDAO(em);

		Location location1 = new Location("Parco Margherita", "Amantea (CS)");
		Partecipazione partecipazione1 = new Partecipazione(null, null, StatoPartecipazione.CONFERMATA);
		Persona persona1 = new Persona("Ajeje", "Brazorf", "ajejeBrazorf@yahoo.com", LocalDate.of(1989, 4, 15),
				Sesso.MASCHIO, new HashSet<Partecipazione>(Arrays.asList(partecipazione1)));

		Evento evento1 = new Evento("Miss maglietta bagnata", LocalDate.of(2023, 6, 15), "Evento benefico",
				TipoEvento.PUBBLICO, 1500, new HashSet<Partecipazione>(Arrays.asList(partecipazione1)), location1);

//		ld.save(location1);
//		pd2.save(partecipazione1);
//		ed.save(evento1);
//		pd.save(persona1);
//		partecipazione1.setPersona(persona1);
//		partecipazione1.setEvento(evento1);
//		pd2.update(partecipazione1);

		Evento foundE = ed.getById(UUID.fromString("476036c8-4ea9-46f9-82c7-a16a5c2e2a51"));
		if (foundE != null) {
			log.info(foundE.toString());
			log.info(foundE.getListaPartecipazioni().toString());
		} else {
			log.info("evento non presente");
		}

		em.close();
		emf.close();

	}

}
