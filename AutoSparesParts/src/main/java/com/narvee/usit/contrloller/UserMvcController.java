package com.narvee.usit.contrloller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.narvee.usit.model.Role;
import com.narvee.usit.model.User;
import com.narvee.usit.service.RoleService;
import com.narvee.usit.service.UserService;

@Controller
public class UserMvcController {
	@Autowired
	UserService userServ;
	@Autowired
	RoleService roleServ;
	
	
	@GetMapping("/addUser")
	public String addUser( Model model) {
		List<Role> r=roleServ.getAllRole();
		System.out.println(r);
		model.addAttribute("Roles", r);
		return "SaveUser";
	}
	
	@PostMapping("/save")
	public String saveUser(User user) {
		
		List<Role> roles=new ArrayList<Role>();
		for (Role role : user.getRoles()) {
			
		roles.add(roleServ.getByRoleId(role.getRoleId()));
			
		}
		user.setRoles(roles);
		userServ.addUser(user);
		return "redirect:/getAllUsers";
		
	}
	
	@PostMapping("/update")
	public String Update(User user) {
		userServ.updateUser(user);
		return "redirect:/getAllUsers";

	}
	
	@GetMapping("/updateUser")
	public String getByid(@RequestParam Integer userId, Model model) {

		User u = userServ.getByUserId(userId);
		model.addAttribute("user", u);
		List<Role>r=roleServ.getAllRole();
		model.addAttribute("role",r);

		return "update";
	}
	
	@GetMapping("/getAllUsers")
	public ModelAndView  getAllUsers() {
		List<User>u=userServ.getAllUsers();
		return new ModelAndView("allUsers", "users", u);
		
	}
	
	@GetMapping("/deleteUser")
	public String delete(@RequestParam Integer userId) {
	
		userServ.deleteUser(userId);
		return "redirect:/getAllUsers";
	}

}
