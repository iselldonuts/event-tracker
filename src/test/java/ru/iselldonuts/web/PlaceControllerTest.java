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

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PlaceController.class)
@ContextConfiguration(classes = MockConfig.class)
class PlaceControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void createTest() throws Exception {

        // Создайте объект который мы будем посылать как json объект
        PlaceCreationRequest placeCreationRequest
                = new PlaceCreationRequest(
                "Test address"
        );

        // Подготовка mock объекта который позвоялет сделать специальный прокси метод
        // который может вернуть определенные данные при вызове функции
        Place place = new Place("Test address");


        when(placeRepository.save(place))
                .thenReturn(place);

        //Выполнение HTTP запроса
        ResultActions resultActions = mockMvc.perform(
                post("/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(placeCreationRequest))
        ).andExpect(status().isOk());


        // Парсинг результата выполнения запроса и конвертация из JSON в POJO
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();


        Place data = mapper.readValue(contentAsString, Place.class);

        // Проверка результата
        assertEquals("Places not equals", place.getAddress(), data.getAddress());
    }
}