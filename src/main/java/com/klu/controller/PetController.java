package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Pet;
import com.klu.model.PetManager;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	PetManager PM;
	@PostMapping("/register")
	public String register(@RequestBody Pet P)
	{
		return PM.registration(P);
	}
	
	@GetMapping("/accessory")
	public String accessory()
	{
		return PM.getAccessory().toString();
	}
	@GetMapping("/participants/{eid}")
	public String participants(@PathVariable("eid") Long eid)
	{
		return PM.participantsList(eid).toString();
	}
	@GetMapping("/getdetails/{id}")
	public String getdetails(@PathVariable("id") Long id)
	{
		return PM.getDetails(id);
	}
	@GetMapping("/Login/{id}")
	public String Login(@PathVariable("id") Long id)
	{
		return PM.getDetails(id);
	}
	@GetMapping("/Registration/{id}")
	public String Registration(@PathVariable("id") Long id)
	{
		return PM.getDetails(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody Pet P)
	{
		return PM.updateDetails(id, P);
	}
	

}
