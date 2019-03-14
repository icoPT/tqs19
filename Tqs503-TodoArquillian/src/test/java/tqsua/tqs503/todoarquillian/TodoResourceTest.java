package tqsua.tqs503.todoarquillian;

import tqsua.tqs503.todoarquillian.todoservice.TodosMapSingleton;
import tqsua.tqs503.todoarquillian.todoservice.ToDoResource;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tqsua.tqs503.todoarquillian.todoservice.ToDo;

@RunWith(Arquillian.class)
public class TodoResourceTest {

    private WebTarget target;
    private ToDo newTodo = new ToDo( 999, "new caption", "new desc" , 1); 

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(
                        RegistryApplication.class, ToDo.class, ToDoResource.class,
                        TodosMapSingleton.class);
    }

    @ArquillianResource
    private URL base;

    @Before
    public void setUp() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "resources/todos").toExternalForm()));
        target.register(ToDo.class);
    }

    

    /**
     * Test of getPerson method, of class MyResource.
     */
    @Test @InSequence(1)
    public void testGetSingle() {

       Response response = target.path("101").request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );
      
        JsonObject todo = response.readEntity( JsonObject.class);
        System.out.println("todo is = " + todo);         
        assertFalse( todo.isEmpty());        
        assertTrue(todo.getString("caption").startsWith("caption 1"));
    }
    
    @Test
    @InSequence(2)
    public void fetchAllTodos() {
        Response response = target.request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );
                    
        JsonArray allTodos = response.readEntity( JsonArray.class);
        assertFalse( allTodos.isEmpty());
        assertNotEquals( 0, allTodos.size());
           
    }
        

   
}