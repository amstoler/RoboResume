package com.example.demo.repository;

import com.example.demo.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepo extends CrudRepository<Skill,Long> {
}
