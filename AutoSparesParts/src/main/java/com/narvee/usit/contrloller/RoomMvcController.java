package com.narvee.usit.contrloller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.narvee.usit.model.Room;
import com.narvee.usit.service.RoomService;
@Controller
public class RoomMvcController {
	@Autowired
	RoomService rSrv;
	
	@GetMapping("/addRoom")
	public String addRoom() {
		return "addRoom";
	}
	

	@PostMapping("/saveRoom")
	public String  saveRoom(Room room) {
		
		rSrv.addRoom(room);;
		return "redirect:/getAllRooms";

	}
	
	@GetMapping("/updateRoom")
	public String  update(@RequestParam  Integer roomId,Model model) {
		
	Room room=rSrv.getByRoomId(roomId);
		
		model.addAttribute("getRoom", room);
		return "UpdateRoom";

	}
	
	@GetMapping("/deleteRoom")
	public String  delete(@RequestParam Integer roomId) {
		
		rSrv.deleteRoom(roomId);
		return "redirect:/getAllRooms";

	}
	
	
	@PostMapping("/updateRoom")
	public String  updateRole(Room room) {
		
		rSrv.addRoom(room);
		return "redirect:/getAllRooms";

	}
	
	
	 @GetMapping("/getAllRooms")
	public ModelAndView getAllroles() {
		List<Room>r=rSrv.getAllRooms();
		return new ModelAndView("getAllRooms", "AllRooms", r);
		
	}
	
}
