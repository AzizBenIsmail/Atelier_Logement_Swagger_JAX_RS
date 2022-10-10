package tn.esprit.utilities;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import tn.esprit.entites.RendezVous;
import tn.esprit.ressources.GestionLogement;
import tn.esprit.ressources.Gestionrendezvous;

@ApplicationPath("logementRest")
public class ResActivator extends Application{

	public ResActivator() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8082");
		beanConfig.setBasePath("LogementService/logementRest");
		beanConfig.setResourcePackage("io.swagger.resources");
		beanConfig.setResourcePackage("tn.esprit");
		beanConfig.setScan(true);
		}
	
	@Override
	public Set<Class<?>> getClasses() {
		

		Set<Class<?>> resources = new HashSet();

		resources.add(Gestionrendezvous.class);
		resources.add(GestionLogement.class);


		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class); 
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources ;
	
	}
	}	
