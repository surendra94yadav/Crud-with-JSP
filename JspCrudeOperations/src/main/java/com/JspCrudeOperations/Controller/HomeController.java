package com.JspCrudeOperations.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.JspCrudeOperations.Entity.Laptop;
import com.JspCrudeOperations.Respository.LaptopRespository;

import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {
	@Autowired
	LaptopRespository laptopRespository;
	
	@GetMapping("/")
	public String home()
	{
		return "Index";
	}
	@GetMapping("/register")
	public String register()
	{
		return "Register";
	}
	@GetMapping("/updateData")
	public String update()
	{
		return "updateLaptopData";
	}
	/*@PostMapping("/SavelaptopData")
	@ResponseBody
	public String SaveData(@RequestParam("id") int id,@RequestParam("brand") String brand,@RequestParam("price") String price)
	{
		Laptop laptop =new Laptop(id,brand,price);
		Laptop lap1 = laptopRespository.save(laptop);
		System.out.println(lap1);
		return "data save sucessfully";
	}*/
	@PostMapping("/SavelaptopData")
	@ResponseBody
	public String SaveData(Laptop laptop )
	{
		laptopRespository.save(laptop);
		return "data save sucessfully";
	}
	
	@GetMapping("/getSingleLaptop/{id}")
	
	public String getSingledata(@PathVariable int id,HttpSession session)
	{
		Optional<Laptop>findbyid=laptopRespository.findById(id);
		Laptop laptop = findbyid.get();
		session.setAttribute("laptop", laptop);
		return "showSingleData";
	}
	@GetMapping("/getAllLaptop")
	public String getAllLaptop(HttpSession session)
	{
		List<Laptop> findAllLatop = laptopRespository.findAll();
		session.setAttribute("AllLpatop", findAllLatop);
		return "showAllLaptop";
	}
	@PostMapping("/upadatelaptopData")
	@ResponseBody
	public String updateLaptopData(Laptop laptop )
	{
		Laptop laptop1 = laptopRespository.save(laptop);
		System.out.println(laptop1);
		return "update is sucessfull!!" ;
	}
	
	@GetMapping("/deletelaptopData/{id}")
	@ResponseBody
	public String deleteData(@PathVariable int id)
	{
		Optional<Laptop>findbyid=laptopRespository.findById(id);
		Laptop laptop = findbyid.get();
		if(laptop!=null)
		{
			laptopRespository.delete(laptop);
		}
	
		
		return "Data Deleted Successfully !!!";
	}



}
