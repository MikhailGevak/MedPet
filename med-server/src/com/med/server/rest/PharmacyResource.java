package com.med.server.rest;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.med.orm.pharmacy.Pharmacy;
import com.med.orm.pharmacy.PharmacyService;

@Path("/pharmacy")
public class PharmacyResource {
	 private final PharmacyService pharmacyService;
	 @Inject
	 public PharmacyResource(PharmacyService pharmacyService){
		 this.pharmacyService = pharmacyService;
	 }
	 @GET
	 @Path("/{id}")
	 @Produces(MediaType.TEXT_HTML)
	 public String get(@PathParam("id")String id) {
		 try{
			 Pharmacy pharmacy = pharmacyService.getEntityById(id);   
			 return pharmacy.toString();
		 }catch(SQLException e){
			 System.out.println(e);
			 return e.getMessage();
		 }
	 }
}
