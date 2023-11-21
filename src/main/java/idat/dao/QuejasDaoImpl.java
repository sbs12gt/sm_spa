package idat.dao;

import org.springframework.stereotype.Repository;

import idat.entity.Quejas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class QuejasDaoImpl implements IQuejasDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Quejas quejas) {
		em.persist(quejas);
	}

}
