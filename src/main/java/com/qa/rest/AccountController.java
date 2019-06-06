package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/Account")
public class AccountController {
	
	@Inject
	private AccountService service;
	
	
	@Path("/getAllAccounts")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/findAnAccount/{id}")
	@GET
	@Produces({"application/json"})
	public String findAnAccount(@PathParam("id") int id) {
		return service.findAnAccount(id);
	}
	
	@Path("/createAnAccount")
	@POST
	@Produces({"application/json"})
	public String createAnAccount(String account) {
		return service.addAccount(account);
	}
	
	@Path("/deleteAnAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAnAccount(@PathParam("id") int id) {
		return service.deleteAccount(id);
	}
	
	
	
	
}
