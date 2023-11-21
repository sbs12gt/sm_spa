package idat.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.dao.IConsultaDao;
import idat.entity.Consulta;

@Service
public class ConsultaServiceImpl implements IConsultaService {
	
	@Autowired
	private IConsultaDao consultaService;
	
	@Transactional
	@Override
	public void save(Consulta consulta) {
		consultaService.save(consulta);
	}

}
