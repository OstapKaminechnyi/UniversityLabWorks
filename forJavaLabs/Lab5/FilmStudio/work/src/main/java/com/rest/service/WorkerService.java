package com.rest.service;

import com.filmstudio.Worker;
import com.manager.StudioManager;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("/workers")
@SessionScoped
public class WorkerService implements Serializable {
    @Inject
    private StudioManager manager;

    @GET
    @Path("{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public  Worker getWorker(@PathParam("id") Integer id) {
        return manager.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createWorker(Worker worker) {

        manager.put(worker);

        return Response.status(200).entity("Good").build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteWorker(Worker worker) {
        manager.remove(worker);
        return Response.status(200).entity("Good").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateWorker(Worker worker) {
        manager.update(worker);
        return Response.status(200).entity("Good").build();
    }
}
