package com.narvee.usit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.SpareParts;
import com.narvee.usit.repository.SparePartsRepository;
import com.narvee.usit.service.SparePartsService;

@Service
public class SparePartsServiceImpl implements SparePartsService {

	@Autowired
	SparePartsRepository sparePartsRepo;
	
	
	@Override
	public void addpart(SpareParts part) {
		sparePartsRepo.save(part);
		
	}

	@Override
	public void delete(Integer SparePartId) {
		sparePartsRepo.deleteById(SparePartId);
	}

	@Override
	public List<SpareParts> getAllSpareParts() {
		return sparePartsRepo.findAll();
	}

	@Override
	public void update(SpareParts sparePart) {
     sparePartsRepo.save(sparePart)	;
	}

	@Override
	public SpareParts getByPartId(Integer sparePartId) {
		return sparePartsRepo.findById(sparePartId).get();
	}

}
