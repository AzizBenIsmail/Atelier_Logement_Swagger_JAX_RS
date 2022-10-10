package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import io.swagger.annotations.Api;
import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.Logement;
import tn.esprit.entites.Logement.Type;

@Path("Logements")
@Api
public class GestionLogement {

	@Path("hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Sayhello()
	{
		return "hello";
	}
	
	LogementBusiness R = new LogementBusiness();
	public static  List<Logement> Log=new ArrayList<Logement>();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Response afficherListRdv(@QueryParam(value="delegation")String  delegation,@QueryParam(value="gouvernorat")String  gouvernorat,@QueryParam(value="type")tn.esprit.entites.Logement.Type  type,@QueryParam(value="prix")float  prix,@QueryParam(value="reference")int reference ) {
		if(delegation==null&&gouvernorat==null&&type==null&&prix==0 &&reference==0)
		{
			if(R.getLogements().size()!=0)
				return Response.status(Status.OK).entity(R.getLogements()).build();
			else
				return Response.status(Status.NOT_FOUND).build();
		}
		else if (delegation!=null)
		{
		if(R.getLogementsByDeleguation(delegation).size()!=0)
			return Response.status(Status.OK).entity(R.getLogementsByDeleguation(delegation)).build();
		else
			return Response.status(Status.NOT_FOUND).build();
		}
		else if (gouvernorat!=null)
		{
			if(R.getLogementsByGouvernorat(gouvernorat).size()!=0)
				return Response.status(Status.OK).entity(R.getLogementsByGouvernorat(gouvernorat)).build();
			else
				return Response.status(Status.NOT_FOUND).build();
			}
		
		
		else if (type!=null)
		{
			if(R.getLogementsByType(type).size()!=0)
				return Response.status(Status.OK).entity(R.getLogementsByType(type)).build();
			else
				return Response.status(Status.NOT_FOUND).build();
			}
	
	else if (prix!=0) {
		if(R.getLogementsByPrix(prix).size()!=0)
			return Response.status(Status.OK).entity(R.getLogementsByPrix(prix)).build();
		else
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
	else {
		if(R.getLogementsByReference(reference)!=null)
			return Response.status(Status.OK).entity(R.getLogementsByReference(reference)).build();
		else
			return Response.status(Status.NOT_FOUND).build();
		}
}}