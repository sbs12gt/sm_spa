package idat.dao;

import org.springframework.stereotype.Repository;

import idat.entity.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ConsultaDaoImpl implements IConsultaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Consulta consulta) {
		em.persist(consulta);
	}

}
