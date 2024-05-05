/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Srimal
 */
public class Todo {
    private int id;
    private String name;
    private String description;
    private boolean state;
    
    public Todo() {
    }

    public Todo(String name, String description, boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Todo(int id, String name, String description, boolean state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }  
    
}
