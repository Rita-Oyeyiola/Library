package com.septa.LibraryProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.septa.LibraryProject.model.Library;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}
