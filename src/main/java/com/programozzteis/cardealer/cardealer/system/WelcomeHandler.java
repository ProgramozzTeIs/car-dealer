package com.programozzteis.cardealer.cardealer.system;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.programozzteis.cardealer.cardealer.users.Admin;
import com.programozzteis.cardealer.cardealer.users.AdminRepository;
import com.programozzteis.cardealer.cardealer.users.Customer;
import com.programozzteis.cardealer.cardealer.users.CustomerRepository;
import com.programozzteis.cardealer.cardealer.users.Salesman;
import com.programozzteis.cardealer.cardealer.users.SalesmanRepository;


@Controller
public class WelcomeHandler {
	
	private final AdminRepository adminRepo;
	private final CustomerRepository customerRepo;
	private final SalesmanRepository salesmanRepo;

	public WelcomeHandler(AdminRepository adminRepo, CustomerRepository customerRepo, SalesmanRepository salesmanRepo) {
		super();
		this.adminRepo = adminRepo;
		this.customerRepo = customerRepo;
		this.salesmanRepo = salesmanRepo;
	}



	@GetMapping("/")
	public String welcome(Map<String, Object> model)
	{
		/** show all default users */

		/** ADMIN */
		Iterable<Admin> admins = this.adminRepo.findAll();
		model.put("admins", admins);
		
		/** CUSTOMER */
		Iterable<Customer> customers = this.customerRepo.findAll();
		model.put("customers", customers);
		
		/** SALESMANS */
		Iterable<Salesman> salesmans = this.salesmanRepo.findAll();
		model.put("salesmans", salesmans);
		
		
		return "welcome";
	}

}
