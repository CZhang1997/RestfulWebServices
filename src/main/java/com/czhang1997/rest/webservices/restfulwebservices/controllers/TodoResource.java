package com.czhang1997.rest.webservices.restfulwebservices.controllers;

import com.czhang1997.rest.webservices.restfulwebservices.beans.ToDo;
import com.czhang1997.rest.webservices.restfulwebservices.utils.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/user/{username}/todos")
    public List<ToDo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @GetMapping("/user/{username}/todos/{id}")
    public ToDo getTodoItemById(@PathVariable String username, @PathVariable long id) {
        return todoHardcodedService.findById(id);
    }

    @PutMapping("/user/{username}/todos/{id}")
    public ResponseEntity<ToDo> updateTodoItemById(@PathVariable String username, @PathVariable long id, @RequestBody ToDo t) {
        ToDo ret =  todoHardcodedService.save(t);
        return new ResponseEntity<ToDo>(ret, HttpStatus.OK);
    }

    @PostMapping("/user/{username}/todos")
    public ResponseEntity<Void> updateTodoItemById(@PathVariable String username, @RequestBody ToDo t) {
        ToDo ret =  todoHardcodedService.save(t);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ret.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/user/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id) {
        ToDo t = todoHardcodedService.deleleById(id);
//        return t;
        if (t != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
