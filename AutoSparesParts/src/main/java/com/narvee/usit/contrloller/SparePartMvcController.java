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
import com.narvee.usit.model.SpareParts;
import com.narvee.usit.model.Vechicle;
import com.narvee.usit.service.RoomService;
import com.narvee.usit.service.SparePartsService;
import com.narvee.usit.service.VechicleService;

@Controller
public class SparePartMvcController {
	
	@Autowired
	SparePartsService spareServ;
	@Autowired
	VechicleService vechicleServ;
	@Autowired
	RoomService rServ;
	
	
	@GetMapping("/addSparePart")
	public String addSparePart(  Model model) {
		List<Vechicle> v=vechicleServ.getAllVechiles();
		
		List<Room> r=rServ.getAllRooms();
		System.out.println(v);
		model.addAttribute("vech", v);
		model.addAttribute("room",r);
		return "SaveSparepart";
	}
	
	@PostMapping("/saveSparePart")
	public String saveUser(SpareParts part,Vechicle vechicle) {
		Vechicle v=vechicleServ.getByVechileId(vechicle.getVehicleId());
		part.setVehicle(v);
		
		spareServ.addpart(part);
		return "redirect:/getAllSpares";
		
	}
	
	@PostMapping("/updateSparePart")
	public String Update(SpareParts spareParts) {
		spareServ.update(spareParts);
		return "redirect:/getAllSpares";

	}
	
	@GetMapping("/updateSparePart")
	public String getByid(@RequestParam Integer partId, Model model) {

		SpareParts s = spareServ.getByPartId(partId);
		model.addAttribute("part", s);
		List<Vechicle>v=vechicleServ.getAllVechiles();
		model.addAttribute("vech",v);

		List<Room> r=rServ.getAllRooms();
		model.addAttribute("room",r);
		
		
		return "UpdateSparePart";
	}
	
	@GetMapping("/getAllSpares")
	public ModelAndView  getAllSpares() {
		List<SpareParts>u=spareServ.getAllSpareParts();
		return new ModelAndView("GetAllSpares", "allSpares", u);
		
	}
	
	@GetMapping("/deletePart")
	public String delete(@RequestParam Integer partId) {
	
		spareServ.delete(partId);
		return "redirect:/getAllSpares";
	}

}
