package com.argProgramaSpallione.ArgentinaPrograma.Services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Education;
import com.argProgramaSpallione.ArgentinaPrograma.Repositories.EducationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

  @Autowired
  private EducationRepository educationRepository;

  public List<Education> getAll() throws Exception {
    try {
      return educationRepository.findAll();
    } catch (Exception e) {
      throw e;
    }
  }

  public Education getOne(String id) throws Exception {
    try {
      Optional<Education> optional = educationRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Education not found");
      }
      return optional.get();
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Education create(String title, Calendar start, Calendar end) throws Exception {
    try {
      if (title == null || title.equals("")) {
        throw new Exception("Title cannot be null");
      }
      if (start == null) {
        throw new Exception("Start cannot be null");
      }
      Education education = new Education();
      education.setTitle(title);
      education.setStart(start);
      education.setEnd(end);
      educationRepository.save(education);
      return education;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Education edit(String id, String title, Calendar start, Calendar end) throws Exception {
    try {
      Optional<Education> optional = educationRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Education not found");
      }
      Education education = optional.get();
      if (title != null && !title.equals("")) {
        education.setTitle(title);
      }
      if (start != null) {
        education.setStart(start);
      }
      if (end != null) {
        education.setEnd(end);
      }
      educationRepository.save(education);
      return education;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public void delete(String id) throws Exception {
    try {
      Optional<Education> optional = educationRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Education not found");
      }
      educationRepository.deleteById(id);
    } catch (Exception exception) {
      throw exception;
    }
  }

}
