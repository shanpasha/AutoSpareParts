package com.narvee.usit.service;

import java.util.List;

import com.narvee.usit.model.Room;

public interface RoomService {
	public void addRoom(Room room);
	public void deleteRoom(Integer roomId);
	public List<Room> getAllRooms();
	public void updateRoom(Room room);
	public Room getByRoomId(Integer roomId);

}
