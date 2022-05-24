package com.argProgramaSpallione.ArgentinaPrograma.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Skill {
  
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String name;
  private String description;
  @Min(0)
  @Max(100)
  private Integer status;

  public Skill() {
  }


  public Skill(String id, String name, String description, Integer status, User user) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.status = status;
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

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
