package todo;

import com.sun.media.jfxmedia.logging.Logger;
import todo.ToDo;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import javax.ws.rs.core.UriInfo;
import todo.TodosMapSingleton;

/**
 *
 * @author airhacks.com
 */
@Path("todos")
public class ToDoResource {

    @Inject
    TodosMapSingleton todosCollection;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        ToDo todo = todosCollection.find(id);

        if (todo == null) {
            return Response.status(NOT_FOUND).build();
        }
        return Response.ok(todo).build();

    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        System.out.println("deleted " + id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {

        List<ToDo> all = todosCollection.findAll();

        if (all == null) {
            return Response.status(NOT_FOUND).build();
        }

        return Response.ok(all).build();
    }

    @POST
    public Response save(ToDo todo) {                                
        todosCollection.add(todo);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(todo.getId())).build()).build();
    }

}
