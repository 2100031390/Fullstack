package com.klu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.klu.entity.Accessory;

import com.klu.entity.Pet;

import com.klu.repository.AccessoryRepository;
import com.klu.repository.PetRepository;

@Service
public class PetManager {
	PetRepository PR;
	 private AccessoryRepository AR;
	 
	 public PetManager(AccessoryRepository AR,PetRepository PR) {
		 this.AR=AR;
		 this.PR=PR;
		 }
	
	//registration
	public String registration(Pet P) {
		PR.save(P);
		
		return "Registered successfully. No of Participants: " + PR.countParticipants();
	}
	
	
	//login
	public String login(Pet P)
	{
		PR.save(P);
		return "Login successfull";
	}
	//Fetch Event Details
		public List<String> getAccessory()
		{
			List<String> list = new ArrayList<String>();
			for(Accessory A : AR.findAll())
			{
				list.add(toJsonString(A));
			}
			return list;
		}
		//View Participants
		public List<String> participantsList(Long eid)
		{
			List<String> list = new ArrayList<String>();
			for(Pet P : PR.readAllbyEid(eid))
			{
				list.add(toJsonString(P));
			}
			return list;
		}
		
		//Convert JAVA object to JSON String
		public String toJsonString(Object obj)
		{
			GsonBuilder GB = new GsonBuilder();
			Gson G = GB.create();
			return G.toJson(obj);
		}
		//Fetch a record from table using primary key
		public String getDetails(Long id)
		{
			Pet tmp = PR.findById(id).get();
			return toJsonString(tmp);
		}
		
		//Update Details
		public String updateDetails(Long id, Pet P)
		{
			Pet tmp = PR.findById(id).get();
			tmp.setName(P.getName());
			tmp.setContact(P.getContact());
			tmp.setEmail(P.getEmail());
			
			tmp.setAddress(P.getAddress());
			PR.save(tmp);
			return "Details has been updated";
		}

}
