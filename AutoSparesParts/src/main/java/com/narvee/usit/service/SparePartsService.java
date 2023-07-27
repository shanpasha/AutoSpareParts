package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.SpareParts;

public interface SparePartsService {
	
	
public void addpart(SpareParts part);
public void delete(Integer SparePartId) ;
public List<SpareParts> getAllSpareParts();
public void update(SpareParts sparePart);
public SpareParts getByPartId(Integer sparePartId);

}
