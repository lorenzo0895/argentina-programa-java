package com.argProgramaSpallione.ArgentinaPrograma.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String name;
  private String surname;
  private String profile_image;
  private String landing_image;
  private String title;
  private String description;
  private String username;
  private String password;

  public User() {
  }

  public User(String id, String name, String surname, String profile_image, String landing_image, String title, String description, String username, String password) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.profile_image = profile_image;
    this.landing_image = landing_image;
    this.title = title;
    this.description = description;
    this.username = username;
    this.password = password;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getProfile_image() {
    return this.profile_image;
  }

  public void setProfile_image(String profile_image) {
    this.profile_image = profile_image;
  }

  public String getLanding_image() {
    return this.landing_image;
  }

  public void setLanding_image(String landing_image) {
    this.landing_image = landing_image;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", surname='" + getSurname() + "'" +
      ", profile_image='" + getProfile_image() + "'" +
      ", landing_image='" + getLanding_image() + "'" +
      ", title='" + getTitle() + "'" +
      ", description='" + getDescription() + "'" +
      ", username='" + getUsername() + "'" +
      ", password='" + getPassword() + "'" +
      "}";
  }

  
}
