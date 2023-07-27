package com.narvee.usit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narvee.usit.model.Room;
import com.narvee.usit.repository.RoomRepository;
import com.narvee.usit.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepo;

	@Override
	public void addRoom(Room room) {
		roomRepo.save(room);

	}

	@Override
	public void deleteRoom(Integer roomId) {
		roomRepo.deleteById(roomId);

	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepo.findAll();
	}

	@Override
	public void updateRoom(Room room) {
		roomRepo.save(room);

	}

	@Override
	public Room getByRoomId(Integer roomId) {
		return roomRepo.findById(roomId).get();
	}

}
