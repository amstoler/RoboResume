package com.example.demo.repository;

import com.example.demo.model.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepo extends CrudRepository<Experience,Long> {
}
