package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;


@Path("rendezvous")
@Api
public class Gestionrendezvous {

	RendezVousBusiness R = new RendezVousBusiness();
	public static  List<RendezVous> Rdvs=new ArrayList<RendezVous>();

	@Path("aa")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Sayhello()
	{
		return "hello";
	}
	
	@ApiOperation(value = "display rendevous" , consumes = MediaType.APPLICATION_JSON)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterrdv(RendezVous rdv) {
		 if(R.addRendezVous(rdv))
				{ return Response.status(Status.CREATED).build(); }
			return Response.status(Status.NOT_FOUND).build();
			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayRendezVousList(){
		Rdvs=R.getListeRendezVous();
		if(Rdvs.size()!=0)
		{	
			 return Response.status(Status.FOUND).entity(Rdvs).build(); }
		else
			return Response.status(Status.NOT_FOUND).build();
			
	}
	@Path("rt")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayRendezVouslogementList(@QueryParam(value="refLogement")int reference){
		Rdvs=R.getListeRendezVousByLogementReference(reference);	
			 return Response.status(Status.FOUND).entity(Rdvs).build(); 

			
	}
	
	@Path("{id}")	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayRendezVousById(@PathParam(value="id")int id){
		RendezVous Rd=R.getRendezVousById(id);	
			 return Response.status(Status.FOUND).entity(Rd).build(); 			
	}
	
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response SupprimerRendezVous(@PathParam(value="id")int id){
		if(R.deleteRendezVous(id))
		{	return Response.status(Status.FOUND).build();	}	 return Response.status(Status.NOT_FOUND).build(); 				
		}
	
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT	
	public Response ModifierRendezVous(@PathParam(value="id")int id ,RendezVous Rend){
		if(R.updateRendezVous(id,Rend))	
		{	return Response.status(Status.FOUND).entity(Rend).build();	}	 return Response.status(Status.NOT_FOUND).build(); 				
		}
	
	
		
}
