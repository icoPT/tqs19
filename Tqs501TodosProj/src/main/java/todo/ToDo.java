/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ico
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement
public class ToDo {
    private long  id;
    private String caption;
    private String description;
    private int priority;

    public ToDo() {
        
    }

    public ToDo(long id, String caption, String description, int priority) {
        this.id = id;
        this.caption = caption;
        this.description = description;
        this.priority = priority;
    }

    
    public long getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }    

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", caption=" + caption + ", description=" + description + ", priority=" + priority + '}';
    }
    
    

}
