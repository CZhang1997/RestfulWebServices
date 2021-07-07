package com.czhang1997.rest.webservices.restfulwebservices.utils;

import com.czhang1997.rest.webservices.restfulwebservices.beans.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<ToDo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new ToDo(++idCounter, "jeff", "learn to dance", new Date(), false));
        todos.add(new ToDo(++idCounter, "jeff", "learn react", new Date(), false));
        todos.add(new ToDo(++idCounter, "jeff", "learn to sleep", new Date(), false));
        todos.add(new ToDo(++idCounter, "jeff", "learn to play", new Date(), false));
    }

    public List<ToDo> findAll() {
        return todos;
    }

    public ToDo save(ToDo t){
        if(t.getId() == -1 || t.getId() == 0){
            t.setId(++idCounter);
            todos.add(t);
        }
        else{
            deleleById(t.getId());
            todos.add(t);
        }
        return t;
    }

    public ToDo deleleById(long id) {
        ToDo todo = findById(id);
        if (todo == null) return null;
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public ToDo findById(long id) {
        for (ToDo t : todos) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
