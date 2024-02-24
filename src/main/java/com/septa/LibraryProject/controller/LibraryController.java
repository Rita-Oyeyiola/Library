package com.septa.LibraryProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.septa.LibraryProject.dto.LibraryDTO;
import com.septa.LibraryProject.service.LibraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/book")
public class LibraryController {

    private final LibraryService libraryService;
    
    public LibraryController(LibraryService libraryService)
    {this.libraryService = libraryService;}

    //POST
    @PostMapping (value = "")
    public Object AddBook(@RequestBody LibraryDTO libraryDTO){

        return libraryService.CreateBook(libraryDTO);
    }


    //GET
    @GetMapping("/")
    public Object getLibrary() {
        return libraryService.getLibrary();
    }

    //PUT
    @PutMapping("/{id}")
    public Object updateBook(@RequestBody LibraryDTO libraryDTO, @PathVariable long id){
        return libraryService.updateBook(libraryDTO, id);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public Object DeleteBook(@PathVariable long id) {return libraryService.DeleteBook(id);}






}
