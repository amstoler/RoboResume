package com.example.demo.repository;

import com.example.demo.model.Reference;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceRepo extends CrudRepository<Reference,Long> {
}
