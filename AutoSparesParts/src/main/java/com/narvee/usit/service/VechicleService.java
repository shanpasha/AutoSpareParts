package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.SpareParts;
import com.narvee.usit.model.Vechicle;

public interface VechicleService {
	
	public void addVechile(Vechicle vechicle);
	public void deleteVechile(Integer vechileId);
	public List<Vechicle> getAllVechiles();
	public void updateVechile(Vechicle vechicle);
	public Vechicle getByVechileId(Integer vechileId);


}
