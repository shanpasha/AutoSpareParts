package com.narvee.usit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.model.Room;
import com.narvee.usit.model.Vechicle;
import com.narvee.usit.service.RoomService;
import com.narvee.usit.service.VechicleService;

@RestController
@RequestMapping("/vechile")
public class VechileController {

	@Autowired
	VechicleService vechileServ;

	@Autowired
	RoomService roomServ;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Vechicle vechile) {

//		Room r2 = roomServ.getByRoomId(vechile.getRoom().getRoomId());
//
//		vechile.setRoom(r2);;
		vechileServ.addVechile(vechile);
		
		return new ResponseEntity<>(HttpStatus.OK).ok(vechile);
	}

	@PutMapping("/update")
	public ResponseEntity<?> Update(@RequestBody Vechicle vechicle) {

		try {
			Vechicle v1 = vechileServ.getByVechileId(vechicle.getVehicleId());
			if (v1 != null) {
				vechileServ.addVechile(vechicle);
				return new ResponseEntity<>(HttpStatus.OK).ok(vechicle);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + vechicle.getVehicleId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		vechileServ.deleteVechile(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(vechileServ.getByVechileId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Vechicle>> getAllRole() {
		return new ResponseEntity<>(HttpStatus.OK).ok(vechileServ.getAllVechiles());

	}

}
