package com.argProgramaSpallione.ArgentinaPrograma.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.User;
import com.argProgramaSpallione.ArgentinaPrograma.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User authenticate(String username, String password) throws Exception {
    try {
      if (username == null || username.equals("")) {
        throw new Exception("Username cannot be null");
      }
      if (password == null || password.equals("")) {
        throw new Exception("Password cannot be null");
      }
      User user = userRepository.findByUsername(username);
      if (user == null) {
        throw new Exception("User not found");
      }
      if (!user.getPassword().equals(password)) {
        throw new Exception("Password incorrect");
      }
      User userToSend = new User();
      userToSend.setUsername(username);
      return userToSend;
    } catch (Exception exception) {
      throw new Exception(exception);
    }
  }

  public List<User> getAll() throws Exception {
    try {
      return userRepository.findAll();
    } catch (Exception exception) {
      throw exception;
    }
  }

  public User getOne(String id) throws Exception {
    try {
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("User not found");
      }
      return optional.get();
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public User create(String name, String surname, String username, String password, String profile_image,
      String landing_image, String title, String description) throws Exception {
    try {
      if (name == null || name.equals("")) {
        throw new Exception("Name cannot be null");
      }
      if (surname == null || surname.equals("")) {
        throw new Exception("Surname cannot be null");
      }
      if (username == null || username.equals("")) {
        throw new Exception("Username cannot be null");
      }
      if (password == null || password.equals("")) {
        throw new Exception("Password cannot be null");
      }
      User user = new User();
      user.setName(name);
      user.setSurname(surname);
      user.setUsername(username);
      user.setPassword(password);
      user.setProfile_image(profile_image);
      user.setLanding_image(landing_image);
      user.setTitle(title);
      user.setDescription(description);
      userRepository.save(user);
      return user;
    } catch (Exception exception) {
      throw new Exception(exception);
    }
  }

  @Transactional
  public User edit(String id, String name, String surname, String username, String password, String profile_image,
      String landing_image, String title, String description) throws Exception {
    try {
      if (username == null || username.equals("")) {
        throw new Exception("Username cannot be null");
      }
      if (password == null || password.equals("")) {
        throw new Exception("Password cannot be null");
      }
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("User not found");
      }
      User user = optional.get();
      if (!user.getPassword().equals(password)) {
        throw new Exception("Password incorrect");
      }
      if (name != null && !name.equals("")) {
        user.setName(name);
      }
      if (surname != null && !surname.equals("")) {
        user.setSurname(surname);
      }
      if (profile_image != null && !profile_image.equals("")) {
        user.setProfile_image(profile_image);
      }
      if (landing_image != null && !landing_image.equals("")) {
        user.setLanding_image(landing_image);
      }
      if (title != null && !title.equals("")) {
        user.setTitle(title);
      }
      if (description != null && !description.equals("")) {
        user.setDescription(description);
      }
      userRepository.save(user);
      return user;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public void delete(String id) throws Exception {
    try {
      Optional<User> optional = userRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("User not found");
      }
      userRepository.deleteById(id);
    } catch (Exception exception) {
      throw exception;
    }
  }

  // @Override
  // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //   User user = userRepository.findByUsername(username);
  //   if (user == null) {
  //     throw new UsernameNotFoundException("User not found with username: " + username);
  //   }
  //   List<GrantedAuthority> permissions = new ArrayList<>();
  //   org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
  //       user.getUsername(), user.getPassword(), permissions);
  //   return userDetails;
  // }

}
