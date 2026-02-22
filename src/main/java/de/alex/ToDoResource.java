package de.alex;

import jakarta.annotation.security.RolesAllowed;
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
@RolesAllowed("user")

public class ToDoResource {

    @GET
    public List<ToDoEntity> getAllToDos() {
        return ToDoEntity.listAll();
    }

@GET
@Path("/{id}")
    public ToDoEntity getSingleToDo(@PathParam("id") Long id) {
        ToDoEntity entity = ToDoEntity.findById(id);
        return entity;
    }

@POST
@Transactional
    public Response createToDo(ToDoEntity toDoEntity) {
        toDoEntity.persist();
        return Response.status(Response.Status.CREATED).entity(toDoEntity).build();
    }

@PATCH
@Path("/{id}")
@Transactional
    public Response updateToDo(@PathParam("id") Long id,ToDoEntity toDoEntity) {
    ToDoEntity entity = ToDoEntity.findById(id);
    if (entity == null) {
        return Response.status(404).build();
    }
    entity.done = toDoEntity.done;
    return Response.status(204).build();
}

@DELETE
@Path("/{id}")
@Transactional
    public Response deleteToDo(@PathParam("id") Long id) {
    ToDoEntity entity = ToDoEntity.findById(id);
    if (entity == null) {
        return Response.status(404).build();
    }
    entity.delete();
    return Response.status(200).build();
}

}
