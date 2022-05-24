package com.argProgramaSpallione.ArgentinaPrograma.Entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Education {
  
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String title;
  @Temporal(TemporalType.DATE)
  private Calendar start;
  @Temporal(TemporalType.DATE)
  private Calendar end;

  public Education() {
  }

  public Education(String id, String title, Calendar start, Calendar end) {
    this.id = id;
    this.title = title;
    this.start = start;
    this.end = end;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", start='" + getStart() + "'" +
      ", end='" + getEnd() + "'" +
      "}";
  }
  
}
