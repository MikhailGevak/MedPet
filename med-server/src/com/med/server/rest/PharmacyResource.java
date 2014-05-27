package com.med.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pharmacy")
public class PharmacyResource {
	 @GET
	 @Path("{id}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String get(@PathParam("id")String id) {
	        return id;
	 }
}
