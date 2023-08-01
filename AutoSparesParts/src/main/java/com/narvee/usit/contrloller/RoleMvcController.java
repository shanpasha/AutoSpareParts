package com.narvee.usit.contrloller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.narvee.usit.model.Role;
import com.narvee.usit.service.RoleService;

@Controller
public class RoleMvcController {
	@Autowired
	RoleService roleServ;
	
	
	@GetMapping("/addRole")
	public String addRole(Role role) {
		return "Role";
	}
	
	@PostMapping("/saveRole")
	public String  saveRole(Role role) {
		
		roleServ.addRole(role);
		return "redirect:/getAllRoles";

	}
	
	@GetMapping("/updateRole")
	public String  update(@RequestParam  Integer roleId,Model model) {
		
	Role role2=roleServ.getByRoleId(roleId);
		
		model.addAttribute("getRole", role2);
		return "UpdateRole";

	}
	
	@GetMapping("/deleteRole")
	public String  delete(@RequestParam Integer roleId) {
		
		roleServ.deleteRole(roleId);
		return "redirect:/getAllRoles";

	}
	
	
	@PostMapping("/updateRole")
	public String  updateRole(Role role) {
		
		roleServ.addRole(role);
		
		return "redirect:/getAllRoles";

	}
	
	
	 @GetMapping("/getAllRoles")
	public ModelAndView getAllroles() {
		List<Role>r=roleServ.getAllRole();
		return new ModelAndView("GetRoles", "allRoles", r);
		
	}
	
	

}
