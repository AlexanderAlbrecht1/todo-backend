package de.alex;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/todo")
public class ToDoResource {

@GET
@Produces(MediaType.APPLICATION_JSON)
    public List<ToDoEntity> getAllToDos() {
    return ToDoEntity.listAll();
}


}
