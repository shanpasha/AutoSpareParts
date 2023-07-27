package com.narvee.usit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.model.SpareParts;
import com.narvee.usit.model.Vechicle;
import com.narvee.usit.repository.RoomRepository;
import com.narvee.usit.repository.SparePartsRepository;
import com.narvee.usit.repository.VechileRepository;
import com.narvee.usit.service.SparePartsService;
import com.narvee.usit.service.VechicleService;
@RequestMapping("/spareParts")
@RestController
public class SparePartController {
	@Autowired
	SparePartsService serv;
	@Autowired
	VechicleService vechileServ;

	@PostMapping("/update")
	public ResponseEntity<?> Update(@RequestBody SpareParts part) {
		try {
			SpareParts a = serv.getByPartId(part.getPartId());

			if (a != null) {
				serv.addpart(part);
			} else {
				throw new Exception();
			}
			return new ResponseEntity<>(HttpStatus.OK).ok(part);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Record Not found in this ID: " + part.getPartId());
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody SpareParts sparePart) {

		Vechicle v2 = vechileServ.getByVechileId(sparePart.getVechicle().getVehicleId());
		sparePart.setVechicle(v2);
		serv.addpart(sparePart);
		return new ResponseEntity<>(HttpStatus.OK).ok(sparePart);
	}

	@GetMapping("/getAllSpareParts")
	public ResponseEntity<?> GetSpareParts() {
		return new ResponseEntity<>(HttpStatus.OK).ok(serv.getAllSpareParts());

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> DeleteById(@PathVariable Integer id) {
		serv.delete(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("deleted succefully id No :" + id);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(serv.getByPartId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not found in this ID :" + id);
		}

	}

}
