package de.alex;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ToDoResource {

@GET

    public List<ToDoEntity> getAllToDos() {
    return ToDoEntity.listAll();
}

@POST
@Transactional

    public Response createToDo(ToDoEntity toDoEntity) {
        toDoEntity.persist();
        return Response.status(Response.Status.CREATED).entity(toDoEntity).build();
    }



}
