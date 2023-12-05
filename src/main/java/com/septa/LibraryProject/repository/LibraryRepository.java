package com.septa.LibraryProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.septa.LibraryProject.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long>{

}
