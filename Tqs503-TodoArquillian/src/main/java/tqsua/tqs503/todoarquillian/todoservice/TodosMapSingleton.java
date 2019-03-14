/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqsua.tqs503.todoarquillian.todoservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author ico
 */
@Startup
@Singleton
public class TodosMapSingleton implements Serializable {
        private HashMap<Long, ToDo> dataCacheMap = null;

    @PostConstruct
    public void initialize() {
        this.dataCacheMap = new HashMap<>();
        add(new ToDo( 101L, "caption 1", "description 1", 0) );
        add(new ToDo( 102L, "caption 2", "description 2", 7) );
    }

    public ToDo find(Long key ) {        
        return dataCacheMap.get( key );

    }

    public List<ToDo> findAll() {
        return new ArrayList<>( dataCacheMap.values() );
    }
    
    public void add( ToDo todo){
        dataCacheMap.put(todo.getId(), todo);
    }  
   
    
}
