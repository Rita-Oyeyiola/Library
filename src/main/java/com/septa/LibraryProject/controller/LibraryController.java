package com.septa.LibraryProject.controller;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.septa.LibraryProject.dto.LibraryDTO;
import com.septa.LibraryProject.service.LibraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {this.libraryService = libraryService;}
    @GetMapping("/hello")
    public String hello() {return "hello world";}

    //POST
    @PostMapping (value = "/library")
    public Object updateBook(@RequestBody LibraryDTO libraryDTO) { return libraryService.updateBook(libraryDTO, libraryDTO.getId()); }

    //GET
    @GetMapping
    public Object fetchAllBooks() {
        return libraryService.FetchAllBooks();
    }

    //PUT
    @PutMapping("library/{id}")
    public Object updateBook(@RequestBody LibraryDTO libraryDTO, @PathVariable long id){
        return libraryService.updateBook(libraryDTO, id);
    }

    //DELETE
    @DeleteMapping("/library/{id}")
    public Object DeleteBook(@PathVariable long id) {return libraryService.DeleteBook(id);}






}
