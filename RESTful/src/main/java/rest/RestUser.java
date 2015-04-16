package rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.Factory;
import dao.QueryDB;
import entity.Product;
import entity.User;

@Path("users")
public class RestUser {
	
	//получение данных о всех юзерах
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getGET() {
		List<User> users = null;
		try {
			users = Factory.getInstance().getUserDAO().getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;    
	}
	
	//получение данных о юзере по Id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getGET(@PathParam(value = "id") int id) {
		User user = null;
		try {
			user = Factory.getInstance().getUserDAO().get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;    
	}
	
	//создание нового юзера
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPOST(User user) {	
		try {
			Factory.getInstance().getUserDAO().add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(201).build();
	}
	
	//обновление юзера по ID
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPUT(@PathParam(value = "id") int id, User user) {
		user.setId(id);
		try {
			User temp = Factory.getInstance().getUserDAO().get(id);
			if (temp==null) return Response.status(404).build(); 
			Factory.getInstance().getUserDAO().update(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(200).build();
	}
	
	//удаление юзера по ID
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDELETE(@PathParam(value = "id") int id) {
		User user = new User();
		user.setId(id);
		try {
			Factory.getInstance().getUserDAO().delete(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(204).build();
	}
	
	//удаление всех юзеров из БД
	@DELETE
	public Response getDELETE() {
		try {
			Factory.getInstance().getUserDAO().delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(204).build();
	}
	
	//создание покупки юзером
	@POST
	@Path("buy/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPost(@PathParam(value = "id") int id, Product product) {
		User user;
		try {
			user = Factory.getInstance().getUserDAO().get(id);
			Factory.getInstance().getProductDAO().add(product);
			QueryDB.purchase(user, product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(201).build();
	}
}
