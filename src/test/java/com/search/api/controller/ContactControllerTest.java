//package com.search.api.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//public class ContactControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void shouldReturnContactsWhichDoesNotStartFromA() throws Exception {
//        //GIVEN
//        String pattern = "^A.*$";
//        //WHEN
//        mockMvc.perform(get("/hello/contacts").param("nameFilter", pattern)
//                .contentType(MediaType.APPLICATION_JSON))
//                //THEN
//                .andExpect(jsonPath("$", hasSize(6)))
//                .andExpect(jsonPath("$[0].id").isNumber())
//                .andExpect(jsonPath("$[0].name", is("Bruno")))
//                .andExpect(jsonPath("$[1].id").isNumber())
//                .andExpect(jsonPath("$[1].name", is("Cody")))
//                .andExpect(jsonPath("$[2].id").isNumber())
//                .andExpect(jsonPath("$[2].name", is("Dmytro")))
//                .andExpect(jsonPath("$[3].id").isNumber())
//                .andExpect(jsonPath("$[3].name", is("Irson")))
//                .andExpect(jsonPath("$[4].id").isNumber())
//                .andExpect(jsonPath("$[4].name", is("Mrok")))
//                .andExpect(jsonPath("$[5].id").isNumber())
//                .andExpect(jsonPath("$[5].name", is("Zork")))
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void shouldReturnContactsWhichDoesNotContainLettersAEI() throws Exception {
//        //GIVEN
//        String pattern = "^.*[AEI].*$";
//        //WHEN
//        mockMvc.perform(get("/hello/contacts").param("nameFilter", pattern)
//                .contentType(MediaType.APPLICATION_JSON))
//                //THEN
//                .andExpect(jsonPath("$", hasSize(5)))
//                .andExpect(jsonPath("$[0].id").isNumber())
//                .andExpect(jsonPath("$[0].name", is("Bruno")))
//                .andExpect(jsonPath("$[1].id").isNumber())
//                .andExpect(jsonPath("$[1].name", is("Cody")))
//                .andExpect(jsonPath("$[2].id").isNumber())
//                .andExpect(jsonPath("$[2].name", is("Dmytro")))
//                .andExpect(jsonPath("$[3].id").isNumber())
//                .andExpect(jsonPath("$[3].name", is("Mrok")))
//                .andExpect(jsonPath("$[4].id").isNumber())
//                .andExpect(jsonPath("$[4].name", is("Zork")))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void shouldReturnNoContent() throws Exception {
//        //GIVEN
//        String pattern = "";
//        //WHEN
//        ResultActions resultActions = mockMvc.perform(get("/hello/contacts").param("nameFilter", pattern)
//                .contentType(MediaType.APPLICATION_JSON))
//                //THEN
//                .andExpect(status().isNoContent());
//    }
//}