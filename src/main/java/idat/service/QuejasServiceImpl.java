package idat.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.dao.IQuejasDao;
import idat.entity.Quejas;

@Service
public class QuejasServiceImpl implements IQuejasService {
	
	@Autowired
	private IQuejasDao quejasService;
	
	@Transactional
	@Override
	public void save(Quejas quejas) {
		quejasService.save(quejas);
	}

}
