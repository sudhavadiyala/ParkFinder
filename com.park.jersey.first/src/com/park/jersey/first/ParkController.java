package com.park.jersey.first;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/parks")
public class ParkController {

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Park> findPark()
	{
		List<Park> parkslst = new ArrayList<Park>();
		ParkDAO rt = new ParkDAO();
		parkslst = rt.findaPark();
		return parkslst;
		
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Park> findAllReservation(@QueryParam("zp") String zip)
	{
		List<Park> reservtns = new ArrayList<>();
		ParkDAO rt = new ParkDAO();
		reservtns = rt.zipSpecificPark(zip);
		return reservtns;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void newParkSubmit(Park p)
	{
		try{
		ParkDAO r = new ParkDAO();
		
		}
		
		catch(Exception e)
		{
			System.out.println("");
			e.printStackTrace();
		}	
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response Parkdelete(@PathParam("id") int id)
	{
		try{
			ParkDAO r = new ParkDAO();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return Response.ok().build();
	}
	
	
	
	
}

