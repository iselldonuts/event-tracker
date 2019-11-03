package ru.iselldonuts.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import ru.iselldonuts.MockConfig;
import ru.iselldonuts.entity.Place;
import ru.iselldonuts.repository.PlaceRepository;
import ru.iselldonuts.web.dto.PlaceCreationRequest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PlaceController.class)
class PlaceControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void createTest() throws Exception {
        PlaceCreationRequest placeCreationRequest1
                = new PlaceCreationRequest(
                "Test address 1"
        );
        PlaceCreationRequest placeCreationRequest2
                = new PlaceCreationRequest(
                "Test address 2"
        );
        PlaceCreationRequest placeCreationRequest3
                = new PlaceCreationRequest(
                "Test address 3"
        );

//        Place place = new Place("Test address");

        mockMvc.perform(
                post("/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(placeCreationRequest1))
        ).andExpect(status().isOk());

        mockMvc.perform(
                post("/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(placeCreationRequest2))
        ).andExpect(status().isOk());

        mockMvc.perform(
                post("/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(placeCreationRequest3))
        ).andExpect(status().isOk());

//        List<Place> places = placeRepository.findAll();

        MvcResult mvcResult = mockMvc.perform(get("/places"))
                .andExpect(status().isOk())
                .andReturn();


        String contentAsString = mvcResult.getResponse().getContentAsString();

        assertNotEquals("get response should not be empty", "[]", contentAsString);
    }
}