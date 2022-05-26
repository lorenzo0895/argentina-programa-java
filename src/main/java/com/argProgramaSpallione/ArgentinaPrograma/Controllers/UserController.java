package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.User;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IException;
import com.argProgramaSpallione.ArgentinaPrograma.Responses.IResponse;
import com.argProgramaSpallione.ArgentinaPrograma.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/find")
  @ResponseBody
  public IResponse getUsers() {
    try {
      List<User> userList = userService.getAll();
      return new IResponse<List<User>>(userList);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @GetMapping("/find/{id}")
  @ResponseBody
  public IResponse getUserById(@PathVariable String id) {
    try {
      User user = userService.getOne(id);
      return new IResponse<User>(user);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("/create")
  @ResponseBody
  public IResponse create(@RequestBody User user) {
    try {
      User newUser = userService.create(user.getName(), user.getSurname(), user.getUsername(), user.getPassword(),
          user.getProfile_image(), user.getLanding_image(), user.getTitle(), user.getDescription());
      return new IResponse<User>(newUser);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PatchMapping("/edit/{id}")
  @ResponseBody
  public IResponse patchProject(@PathVariable String id, @RequestBody User user) {
    try {
      User userEdited = userService.edit(id, user.getName(), user.getSurname(), user.getUsername(), user.getPassword(),
          user.getProfile_image(), user.getLanding_image(), user.getTitle(), user.getDescription());
      return new IResponse<User>(userEdited);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @DeleteMapping("/delete/{id}")
  @ResponseBody
  public IResponse deleteProject(@PathVariable String id) {
    try {
      userService.delete(id);
      return new IResponse<String>("User deleted");
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

  @PostMapping("/auth")
  @ResponseBody
  public IResponse auth(@RequestBody User request) {
    try {
      User token = userService.authenticate(request.getUsername(), request.getPassword());
      return new IResponse<User>(token);
    } catch (Exception exception) {
      return new IResponse<IException>(new IException(exception.getMessage()));
    }
  }

}
