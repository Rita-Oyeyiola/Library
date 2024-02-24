package com.septa.LibraryProject.service;

import com.septa.LibraryProject.dto.LibraryDTO;
import com.septa.LibraryProject.model.Library;
import com.septa.LibraryProject.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
    public Object CreateBook(LibraryDTO libraryDTO){
        Library library = new Library();

        library.setTitle(libraryDTO.getTitle());
        library.setAuthor(libraryDTO.getAuthor());
        library.setISBN(libraryDTO.getISBN());

        return libraryRepository.save(library);
    }
    public Object getLibrary() {return libraryRepository.findAll();}

    public Object updateBook (LibraryDTO libraryDTO, long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

    library.setTitle(libraryDTO.getTitle());
    library.setAuthor(libraryDTO.getTitle());
    library.setISBN(libraryDTO.getISBN());

    return libraryRepository.save(library);
    }

    public Object DeleteBook (Long id){
        return "book have been deleted";

    }

}
