package kr.co.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.todo.service.AppService;
import kr.co.todo.vo.TodoVO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppController {
	
	@Autowired
	private AppService service;
	
	@GetMapping("todo")
	public List<TodoVO> todo() {
		return service.selectTodos();
	}

	@PostMapping("todo")
	public TodoVO todo(@RequestBody TodoVO vo) {
		service.insertTodo(vo);
		return vo;
	}
	
	@DeleteMapping("todo/{no}")
	public List<TodoVO> todo(@PathVariable("no") int no) {
		service.deleteTodo(no);
		return service.selectTodos();
	}
	@DeleteMapping("clear")
	public void clearTodo() {
		service.deleteTodoAll();
	}
}
