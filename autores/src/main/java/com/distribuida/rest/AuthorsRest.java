package com.distribuida.rest;

import com.distribuida.Entity.Authors;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/authors")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//@Consumes(MediaType.APPLICATION_JSON)
public class AuthorsRest {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public List<Authors> fruits() {

		return Authors.listAll();
		}
	
	@GET
	@Path("/{id}")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Authors getById(Long id) {
			return Authors.findById(id);
		}
	@POST
	@Transactional
	public Response AddAuthor(Authors author) {
		author.id = null;
		author.persist();
		return Response.status(Response.Status.CREATED).entity(author).build();
	}
	
	
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Authors EditAuthor(Long id, Authors author) {
		Authors entity = Authors.findById(id);
		if(entity == null) {
			throw new NotFoundException();
		}
		entity.first_name = author.first_name;
		entity.last_name = author.last_name;
		
		return entity;
	}
	@DELETE
	@Path("/{id}")
	@Transactional
	public void DeleteAuthor(Long id) {
		Authors entity = Authors.findById(id);
		if(entity == null) {
			throw new NotFoundException();
		}
		entity.delete();
	}
}
