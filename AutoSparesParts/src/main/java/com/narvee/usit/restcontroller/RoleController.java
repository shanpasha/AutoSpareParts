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

import com.narvee.usit.model.Role;
import com.narvee.usit.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleServ;

	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody Role role) {

		roleServ.addRole(role);
		return new ResponseEntity<>(HttpStatus.OK).ok(role);
	}

	@PutMapping("/update")
	public ResponseEntity<?> UpdateRole(@RequestBody Role role) {

		try {
			Role r = roleServ.getByRoleId(role.getRoleId());
			if (r != null) {
				roleServ.addRole(role);
				return new ResponseEntity<>(HttpStatus.OK).ok(role);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + role.getRoleId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id) {

		roleServ.deleteRole(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByRole(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(roleServ.getByRoleId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Role>> getAllRole() {

		return new ResponseEntity<>(HttpStatus.OK).ok(roleServ.getAllRole());

	}

}
