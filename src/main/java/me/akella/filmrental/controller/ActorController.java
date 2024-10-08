package me.akella.filmrental.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.akella.filmrental.entity.Actor;
import me.akella.filmrental.model.CreateActorRequest;
import me.akella.filmrental.model.GetActorsResponse;
import me.akella.filmrental.service.ActorService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/actors")
public class ActorController {

    @Inject
    ActorService actorService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors() {
        List<Actor> actors = actorService.getAllActors();

        List<GetActorsResponse> response = new ArrayList<>();
        actors.forEach(
                actor -> response.add(new GetActorsResponse(actor.getId(), actor.getFirstName(), actor.getLastName())));
        return Response.ok(response)
                       .build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createActor(CreateActorRequest request) {
        Actor newActor = new Actor();
        newActor.setFirstName(request.firstName());
        newActor.setLastName(request.lastName());
        boolean status = actorService.saveNewActor(newActor);
        return status
               ? Response.serverError()
                         .build()
               : Response.created(URI.create("/actor/" + newActor.getId()))
                         .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id") Integer id) {
        Actor actor = actorService.findActorById(id);
        if (null == actor) {
            return Response.noContent()
                           .build();
        } else {
            GetActorsResponse resp = new GetActorsResponse(actor.getId(), actor.getFirstName(), actor.getLastName());
            return Response.ok(resp)
                           .build();
        }
    }

}
