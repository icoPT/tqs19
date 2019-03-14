/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it;

import java.util.Random;

import javax.json.JsonArray;
import javax.json.JsonObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ico
 */
public class TodosResourceTest {
    
    private javax.ws.rs.client.Client client;
    private javax.ws.rs.client.WebTarget target;
    
    @Before
    public void initClient() {
        final ClientConfig configuration = new ClientConfig();
        configuration.property(ClientProperties.CONNECT_TIMEOUT, 100);
        configuration.property(ClientProperties.READ_TIMEOUT, 5000);        
        configuration.connectorProvider(new HttpUrlConnectorProvider());
        this.client = ClientBuilder.newClient( configuration );
        this.target = client.target("http://localhost:8080/TodosProj/resources/todos/");
    }
    
    @Test
    public void fetchSingleTodo() {
        Response response = target.path("101").request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );
      
        JsonObject todo = response.readEntity( JsonObject.class);
        System.out.println("todo is = " + todo);         
        assertFalse( todo.isEmpty());        
        assertTrue(todo.getString("caption").startsWith("caption 1"));

    }
    
    @Test
    public void fetchAllTodos() {
        Response response = target.request( MediaType.APPLICATION_JSON).get();
        assertThat( response.getStatus(), CoreMatchers.is(200) );
                    
        JsonArray allTodos = response.readEntity( JsonArray.class);
        assertFalse( allTodos.isEmpty());
        assertNotEquals( 0, allTodos.size());
           
    }
    
    @Test
    public void deleteTodos() {
       Response response = target.path("something").request().delete();
    }
    
    @Test
    public void createAndReadTodo() {        
        String jsonNewTodo = "{ \"caption\": \"caption 777\", \"description\": \"description 777\", \"id\": \"777\" }";
      
       System.out.println("\t Create a new entity");
       Response response = target.request(APPLICATION_JSON_TYPE).post( Entity.json(jsonNewTodo));
       assertEquals(201, response.getStatus()); 
       
       //FIXME tested in wildfly, bur failing in payara...
       System.out.println("\t retrieve entity");       
       response = target.path("777").request( MediaType.APPLICATION_JSON).get();
       assertThat( response.getStatus(), CoreMatchers.is(200) );
       JsonObject todo = response.readEntity( JsonObject.class);             
       assertTrue(todo.getString("caption").startsWith("caption 777"));
       
       System.out.println("\t deleting test entity");
       response = target.path("777").request().delete();
       assertThat( response.getStatus(), CoreMatchers.is(204) );
       
    }
    
    @After
    public void cleanup() {
        client.close();
    }
   

    
}
