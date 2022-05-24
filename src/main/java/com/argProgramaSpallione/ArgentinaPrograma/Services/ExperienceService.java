package com.argProgramaSpallione.ArgentinaPrograma.Services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Experience;
import com.argProgramaSpallione.ArgentinaPrograma.Repositories.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

  @Autowired
  private ExperienceRepository experienceRepository;

  public List<Experience> getAll() throws Exception {
    try {
      return experienceRepository.findAll();
    } catch (Exception exception) {
      throw exception;
    }
  }

  public Experience getOne(String id) throws Exception {
    try {
      Optional<Experience> optional = experienceRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Experience not found");
      }
      return optional.get();
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Experience create(String role, String company, String description, Calendar start, Calendar end)
      throws Exception {
    try {
      if (role == null || role.equals("")) {
        throw new Exception("Role cannot be null");
      }
      if (company == null || company.equals("")) {
        throw new Exception("Company cannot be null");
      }
      if (start == null) {
        throw new Exception("Company cannot be null");
      }
      Experience experience = new Experience();
      experience.setRole(role);
      experience.setCompany(company);
      experience.setDescription(description);
      experience.setStart(start);
      experience.setEnd(end);
      experienceRepository.save(experience);
      return experience;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Experience edit(String id, String role, String company, String description, Calendar start, Calendar end)
      throws Exception {
    try {
      Optional<Experience> optional = experienceRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Experience not found");
      }
      Experience experience = optional.get();
      if (role != null && !role.equals("")) {
        experience.setRole(role);
      }
      if (company != null && !company.equals("")) {
        experience.setCompany(company);
      }
      if (description != null && !description.equals("")) {
        experience.setDescription(description);
      }
      if (start != null) {
        experience.setStart(start);
      }
      if (end != null) {
        experience.setEnd(end);
      }
      experienceRepository.save(experience);
      return experience;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public void delete(String id) throws Exception {
    try {
      Optional<Experience> optional = experienceRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Experience not found");
      }
      experienceRepository.deleteById(id);
    } catch (Exception exception) {
      throw exception;
    }
  }

}
