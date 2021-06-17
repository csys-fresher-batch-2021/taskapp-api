package in.taskapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.taskapp.dto.Message;
import in.taskapp.model.User;
import in.taskapp.service.UserService;

@Controller
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService = new UserService();

	@PostMapping
	public ResponseEntity<Object> register(@RequestBody User user) {
		try {
			System.out.println(user);
			userService.addUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
