package pl.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id).orElse(null);
    }

//    @PostMapping
//    public Todo saveOrUpdate(@RequestBody Todo todo) {
//        return todoService.saveOrUpdate(todo);
//    }

    @PostMapping
    public String saveOrUpdate(@RequestBody Todo todo) {
        Todo savedTodo = todoService.saveOrUpdate(todo);
        return "{ \"id\": " + savedTodo.getId() + " }";
//        to tak nie powinno wygladac, tylko w response zwracac id jako json
    }

//    http://localhost:8080/api/todos/{id}?completed=true
    @PatchMapping("/{id}")
    public String updateCompletedStatus(@PathVariable Long id, @RequestParam boolean completed) {
        Todo existingTodo = todoService.getTodoById(id).orElse(null);

        if (existingTodo != null) {
            existingTodo.setCompleted(completed);
            todoService.saveOrUpdate(existingTodo);
            return "{ \"id\": " + id + " }";
        } else {
            return "{ \"error\": \"Todo not found with id " + id + "\" }";
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
