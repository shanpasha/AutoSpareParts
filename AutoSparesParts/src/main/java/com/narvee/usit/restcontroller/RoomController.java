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
import com.narvee.usit.service.RoomService;
@RequestMapping("/room")
@RestController
public class RoomController {

	@Autowired
	RoomService roomServ;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Room room) {

		roomServ.addRoom(room);
		return new ResponseEntity<>(HttpStatus.OK).ok(room);
	}

	@PutMapping("/update")
	public ResponseEntity<?> Update(@RequestBody Room room) {

		try {
			Room r = roomServ.getByRoomId(room.getRoomId());
			if (r != null) {
				roomServ.addRoom(room);
				return new ResponseEntity<>(HttpStatus.OK).ok(room);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + room.getRoomId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		try {
			Room l = roomServ.getByRoomId(id);
			if (l != null) {
				roomServ.deleteRoom(id);
				return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");

			} else {
				throw new Exception();

			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok("Record Not Found In This ID: " + id  );

		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(roomServ. getByRoomId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Room>> getAllRole() {
		return new ResponseEntity<>(HttpStatus.OK).ok(roomServ.getAllRooms());

	}
}