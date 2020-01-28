package com.demo.sahan1;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource 
{
	
	AlienRepository repo= new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})  
	
	public List<Alien> getAlien()
	{
		return repo.getAlients();
	}  
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
	@Path("alien/{id}")
	
	public Alien getAlien1(@PathParam("id")int id)
	{
		return repo.getAlien(id);
	}
	
	@POST
	@Path("aliens")
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		
		if(repo.getAlien(a1.getId()).getId()==0)
		{
			repo.create(a1);
		}
		else
		{
			repo.update(a1);
		}
		
		return a1;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
	@Path("delete/{id}")
	public Alien deleteAlien(@PathParam("id")int id)
	{
		Alien a=repo.getAlien(id);
		
		if(a.getId()!=0)
		{
			repo.delete(id);
		}
		return a;
	}
	
	
	
	
}
  