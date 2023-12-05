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

    public Object AddBook(LibraryDTO libraryDTO){
        Library library = new Library();

        library.setId(libraryDTO.getId());
        library.setTitle(libraryDTO.getTitle());
        library.setAuthor(libraryDTO.getAuthor());
        library.setISBN(libraryDTO.getISBN());
        library.setCreatedDate(libraryDTO.getCreatedDate());
        library.setUpdatedDate(libraryDTO.getUpdatedDate());

        return libraryRepository.save(library);
    }
    public Object FetchAllBooks() {return libraryRepository.findAll();}

    public Object updateBook (LibraryDTO libraryDTO, Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

    library.setId(libraryDTO.getId());
    library.setTitle(libraryDTO.getTitle());
    library.setAuthor(libraryDTO.getTitle());
    library.setISBN(libraryDTO.getISBN());
    library.setCreatedDate(libraryDTO.getCreatedDate());
    library.setUpdatedDate(libraryDTO.getUpdatedDate());

    return libraryRepository.save(library);
    }

    public Object DeleteBook (Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found") );

        libraryRepository.delete(library);
        return "book have been deleted";

    }

}
