package com.septa.LibraryProject.controller;

import com.septa.LibraryProject.dto.LibraryDTO;
import com.septa.LibraryProject.model.Library;
import com.septa.LibraryProject.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LibraryControllerTest {

   MockMvc mockMvc;
   @Mock
   LibraryService libraryService;

   @InjectMocks
   LibraryController libraryController;

   LibraryDTO libraryDTO;

   Gson gson;

   @BeforeEach
    void setUp() {
     Object LibraryController = new Object();
     mockMvc = MockMvcBuilders.standaloneSetup(LibraryController).build();
     libraryDTO = new LibraryDTO();
     libraryDTO.setAuthor("John Smith");
     libraryDTO.setISBN(123-4);
     libraryDTO.setTitle("Think and grow rich");

     gson = new Gson();
    }

    @Test
    void createLibrary() throws Exception {
       when(libraryService.getLibrary()).thenReturn(new Library());
       mockMvc.perform(post("http://localhost:5000/api/book")
               .accept(MediaType.APPLICATION_JSON_VALUE)
               .contentType(MediaType.APPLICATION_JSON_VALUE)
               .content(gson.toJson(libraryDTO)))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    void getLibrary() throws Exception {
//       when(libraryService.getLibrary()).thenReturn(List.of(new Library()));
//       mockMvc.perform(get("http://localhost:5000/api/book"))
//




//    }
//    @Test
//    void getLibrary() throws Exception {
//       when(libraryService.getLibrary()).thenReturn(List.of(new Library()));
//    }

}
