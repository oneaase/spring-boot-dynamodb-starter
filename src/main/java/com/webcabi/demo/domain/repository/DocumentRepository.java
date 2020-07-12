package com.webcabi.demo.domain.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.webcabi.demo.domain.model.Document;

@EnableScan
public interface DocumentRepository extends CrudRepository<Document, String> {
}
