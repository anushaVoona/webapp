package com.MyFIrstWebApplication.Webapplication.LoginController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJsp {

	private TodoService todoservice;
	private TodoRepository todoRepository;

	@Autowired
	public TodoControllerJsp(TodoService todoservice, TodoRepository todoRepository) {
		super();
		this.todoservice = todoservice;
		this.todoRepository = todoRepository;
	}

	@RequestMapping("userlist")
	public String getUserList(ModelMap model) {

		List<Todo> todo = todoRepository.findByUsername(getUsername());
		model.addAttribute("todo", todo);

		return "Todo";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setUserList(ModelMap model) {
		// String username = (String) model.get("name");
		String username = getUsername();
		Todo todo = new Todo(0, "", 0, 0, username);
		model.put("todo", todo);
		return "additem";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setUserListInTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// String username = (String) model.get("name");
		String username = getUsername();
		if (result.hasErrors()) {
			return "additem";
		}
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:userlist";
	}

	@RequestMapping("delete")
	public String deleteFromList(@RequestParam int id) {

		todoRepository.deleteById(id);

		return "redirect:userlist";

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String UpdatetheList(@RequestParam int id, ModelMap model) {
		Todo todobyid = todoRepository.findById(id).get();
		Todo todo = todoRepository.save(todobyid);
		model.put("todo", todo);
		return "additem";

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String UpdatetheListIWithParams(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "additem";
		}
		// todoservice.setTodosInUpdate(todo, todo.getId());
		todo.setUsername(getUsername());
		todoRepository.save(todo);
		return "redirect:userlist";

	}

	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();

	}

}
