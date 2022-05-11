package com.mywebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mywebapp.dao.AlienRepo;
import com.mywebapp.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int alienId) {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Optional<Alien> alien = repo.findById(alienId);
//		
////		System.out.println(repo.findByTechnology("DataScience"));
////		System.out.println(repo.findByAlienIdGreaterThan(102));
//		System.out.println(repo.findByTechSorted("DataScience"));
//		
//		 mv.addObject("alien",alien);
//		return mv;
//	}
	
	
	@RequestMapping("/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{alienId}")
	public Optional<Alien> getAlien(@PathVariable("alienId") int id) {
		return repo.findById(id);
	}
	
	@PostMapping(path = "/alien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		 return alien;
	}
	
	@DeleteMapping("/alien/{alienId}")
	public String deleteAlien(@PathVariable int alienId) {
		Alien a = repo.getById(alienId);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path = "/alien", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		
		return alien;
	}
}
