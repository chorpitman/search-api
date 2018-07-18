package com.search.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnContactsWhichDoesNotStartFromA() throws Exception {
        //GIVEN
        String pattern = "^A.*$";
        //WHEN
        mockMvc.perform(get("/hello/contacts/page/0/").param("nameFilter", pattern)
                .contentType(MediaType.APPLICATION_JSON))
                //THEN
                .andExpect(jsonPath("$.contacts", hasSize(12)))
                .andExpect(jsonPath("$.contacts[0].id").isNumber())
                .andExpect(jsonPath("$.contacts[0].name", is("AaihjEo")))
                .andExpect(jsonPath("$.contacts[1].id").isNumber())
                .andExpect(jsonPath("$.contacts[1].name", is("Akiyvur")))
                .andExpect(jsonPath("$.contacts[2].id").isNumber())
                .andExpect(jsonPath("$.contacts[2].name", is("AAbnnPH")))
                .andExpect(jsonPath("$.contacts[3].id").isNumber())
                .andExpect(jsonPath("$.contacts[3].name", is("ASkaKrC")))
                .andExpect(jsonPath("$.contacts[4].id").isNumber())
                .andExpect(jsonPath("$.contacts[4].name", is("AUCvkCC")))
                .andExpect(jsonPath("$.contacts[5].id").isNumber())
                .andExpect(jsonPath("$.contacts[5].name", is("ACZVpiu")))
                .andExpect(jsonPath("$.contacts[6].id").isNumber())
                .andExpect(jsonPath("$.contacts[6].name", is("ABdJbPd")))
                .andExpect(jsonPath("$.contacts[7].id").isNumber())
                .andExpect(jsonPath("$.contacts[7].name", is("ANEUUYF")))
                .andExpect(jsonPath("$.contacts[8].id").isNumber())
                .andExpect(jsonPath("$.contacts[8].name", is("AsgnBwX")))
                .andExpect(jsonPath("$.contacts[9].id").isNumber())
                .andExpect(jsonPath("$.contacts[9].name", is("AKCJQAH")))
                .andExpect(jsonPath("$.contacts[10].id").isNumber())
                .andExpect(jsonPath("$.contacts[10].name", is("ANEUUYF")))
                .andExpect(jsonPath("$.contacts[11].id").isNumber())
                .andExpect(jsonPath("$.contacts[11].name", is("Akiyvur")))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnContactsWhichDoesNotContainLettersAEI() throws Exception {
        //GIVEN
        String pattern = "^.*[AEI].*$";
        //WHEN
        mockMvc.perform(get("/hello/contacts/page/0/").param("nameFilter", pattern)
                .contentType(MediaType.APPLICATION_JSON))
                //THEN
                .andExpect(jsonPath("$.contacts", hasSize(13)))
                .andExpect(jsonPath("$.contacts[0].id").isNumber())
                .andExpect(jsonPath("$.contacts[0].name", is("AaihjEo")))
                .andExpect(jsonPath("$.contacts[1].id").isNumber())
                .andExpect(jsonPath("$.contacts[1].name", is("Akiyvur")))
                .andExpect(jsonPath("$.contacts[2].id").isNumber())
                .andExpect(jsonPath("$.contacts[2].name", is("AAbnnPH")))
                .andExpect(jsonPath("$.contacts[3].id").isNumber())
                .andExpect(jsonPath("$.contacts[3].name", is("ASkaKrC")))
                .andExpect(jsonPath("$.contacts[4].id").isNumber())
                .andExpect(jsonPath("$.contacts[4].name", is("AUCvkCC")))
                .andExpect(jsonPath("$.contacts[5].id").isNumber())
                .andExpect(jsonPath("$.contacts[5].name", is("ACZVpiu")))
                .andExpect(jsonPath("$.contacts[6].id").isNumber())
                .andExpect(jsonPath("$.contacts[6].name", is("ABdJbPd")))
                .andExpect(jsonPath("$.contacts[7].id").isNumber())
                .andExpect(jsonPath("$.contacts[7].name", is("ANEUUYF")))
                .andExpect(jsonPath("$.contacts[8].id").isNumber())
                .andExpect(jsonPath("$.contacts[8].name", is("AsgnBwX")))
                .andExpect(jsonPath("$.contacts[9].id").isNumber())
                .andExpect(jsonPath("$.contacts[9].name", is("AKCJQAH")))
                .andExpect(jsonPath("$.contacts[10].id").isNumber())
                .andExpect(jsonPath("$.contacts[10].name", is("mIteZHz")))
                .andExpect(jsonPath("$.contacts[11].id").isNumber())
                .andExpect(jsonPath("$.contacts[11].name", is("ANEUUYF")))
                .andExpect(jsonPath("$.contacts[12].id").isNumber())
                .andExpect(jsonPath("$.contacts[12].name", is("Akiyvur")))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNoContent() throws Exception {
        //GIVEN
        String pattern = "";
        //WHEN
        ResultActions resultActions = mockMvc.perform(get("/hello/contacts/page/0/").param("nameFilter", pattern)
                .contentType(MediaType.APPLICATION_JSON))
                //THEN
                .andExpect(status().isBadRequest());
    }
}