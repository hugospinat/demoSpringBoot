package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberingControllerTest {

    @InjectMocks
    private NumberingController numberingController;

    @Mock
    private NumberingRepository numberingRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testConfigure() throws Exception {
        NumberingCriteria[] numberingCriterias = new NumberingCriteria[] {
            new NumberingCriteria("name", 10, "", "", 1), 
            new NumberingCriteria("firstName", 10, "", "", 2), 
            new NumberingCriteria("birthDate", 4, "", "", 3), 
            new NumberingCriteria("counter", 5, "", "", 4)
        };

        mockMvc.perform(MockMvcRequestBuilders
            .post("/configure")
            .param("counter", "10")
            .content(objectMapper.writeValueAsString(numberingCriterias))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());


        MvcResult r = mockMvc.perform(MockMvcRequestBuilders
            .get("/getNumberingIds"))
            .andExpect(status().isOk())
            .andReturn();
        System.out.println(r.getResponse().getContentAsString());
    }
}