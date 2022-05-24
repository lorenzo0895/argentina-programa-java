package com.argProgramaSpallione.ArgentinaPrograma.Entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Experience {
  
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String role;
  private String description;
  @Temporal(TemporalType.DATE)
  private Calendar start;
  @Temporal(TemporalType.DATE)
  private Calendar end;
  private String company;

  public Experience() {
  }

  public Experience(String id, String role, String description, Calendar start, Calendar end, String company) {
    this.id = id;
    this.role = role;
    this.description = description;
    this.start = start;
    this.end = end;
    this.company = company;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Calendar getStart() {
    return this.start;
  }

  public void setStart(Calendar start) {
    this.start = start;
  }

  public Calendar getEnd() {
    return this.end;
  }

  public void setEnd(Calendar end) {
    this.end = end;
  }

  public String getCompany() {
    return this.company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

}
