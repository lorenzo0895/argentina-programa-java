package com.argProgramaSpallione.ArgentinaPrograma.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.Skill;
import com.argProgramaSpallione.ArgentinaPrograma.Repositories.SkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
  
  @Autowired
  private SkillRepository skillRepository;

  public List<Skill> getAll() throws Exception {
    try {
      return skillRepository.findAll();
    } catch (Exception exception) {
      throw exception;
    }
  }

  public Skill getOne(String id) throws Exception {
    try {
      Optional<Skill> optional = skillRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Skill not found");
      }
      return optional.get();
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Skill create(String name, String description, Integer status) throws Exception {
    try {
      if (name == null || name.equals("")) {
        throw new Exception("Name cannot be null");
      }
      if (description == null || description.equals("")) {
        throw new Exception("Description cannot be null");
      }
      if (status == null) {
        throw new Exception("Status cannot be null");
      }
      Skill skill = new Skill();
      skill.setName(name);
      skill.setDescription(description);
      skill.setStatus(status);
      skillRepository.save(skill);
      return skill;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public Skill edit(String id, String name, String description, Integer status) throws Exception {
    try {
      Optional<Skill> optional = skillRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Skill not found");
      }
      Skill skill = optional.get();
      if (name != null && !name.equals("")) {
        skill.setName(name);
      }
      if (description != null && !description.equals("")) {
        skill.setDescription(description);
      }
      if (status != null && status >= 0 && status <= 100) {
        skill.setStatus(status);
      }
      skillRepository.save(skill);
      return skill;
    } catch (Exception exception) {
      throw exception;
    }
  }

  @Transactional
  public void delete(String id) throws Exception {
    try {
      Optional<Skill> optional = skillRepository.findById(id);
      if (!optional.isPresent()) {
        throw new Exception("Skill not found");
      }
      skillRepository.deleteById(id);
    } catch (Exception exception) {
      throw exception;
    }
  }
}
