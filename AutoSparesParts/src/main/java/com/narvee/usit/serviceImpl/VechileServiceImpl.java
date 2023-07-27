package com.narvee.usit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.Vechicle;
import com.narvee.usit.repository.VechileRepository;
import com.narvee.usit.service.VechicleService;

@Service
public class VechileServiceImpl implements VechicleService {

	@Autowired
	VechileRepository vechileRepo;

	@Override
	public void addVechile(Vechicle vechicle) {
		vechileRepo.save(vechicle);
	}

	@Override
	public void deleteVechile(Integer vechileId) {

		vechileRepo.deleteById(vechileId);
	}

	@Override
	public List<Vechicle> getAllVechiles() {
		return vechileRepo.findAll();
	}

	@Override
	public void updateVechile(Vechicle vechicle) {
		vechileRepo.save(vechicle);

	}

	@Override
	public Vechicle getByVechileId(Integer vechileId) {
		return vechileRepo.findById(vechileId).get();
	}

}
