package com.narvee.usit.contrloller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.narvee.usit.model.Vechicle;
import com.narvee.usit.service.VechicleService;

@Controller
public class VehicleMvcController {

	@Autowired
	VechicleService vSrv;
	
	@GetMapping("/addVehicle")
	public String addRoom() {
		return "AddVehicle";
	}
	

	@PostMapping("/saveVehicle")
	public String  saveVehicle(Vechicle vehicle) {
		
		vSrv.addVechile(vehicle);
		return "redirect:/getAllVehicle";

	}
	
	@GetMapping("/updateVehicle")
	public String  update(@RequestParam  Integer vehicleId,Model model) {
		
	Vechicle v=vSrv.getByVechileId(vehicleId);
		
		model.addAttribute("getVehicle", v);
		return "UpdateVehicle";

	}
	
	@GetMapping("/deleteVehicle")
	public String  delete(@RequestParam Integer vehicleId) {
		
		vSrv.deleteVechile(vehicleId);
		return "redirect:/getAllVehicle";

	}
	
	
	@PostMapping("/updateVehicle")
	public String  updateRole(Vechicle vehicle) {
		
		vSrv.addVechile(vehicle);
		return "redirect:/getAllVehicle";

	}
	
	
	 @GetMapping("/getAllVehicle")
	public ModelAndView getAllroles() {
		List<Vechicle>v=vSrv.getAllVechiles();
		return new ModelAndView("getAllVehicle", "AllVehicle", v);
		
	}
}
