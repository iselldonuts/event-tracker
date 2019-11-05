package ru.iselldonuts.web;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import ru.iselldonuts.MockConfig;
import ru.iselldonuts.entity.Place;
import ru.iselldonuts.repository.PlaceRepository;
import ru.iselldonuts.web.dto.PlaceCreationRequest;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;


@ContextConfiguration(classes = MockConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void shouldSaveAndFetchFromHttp() throws Exception {

        String address1 = "Test address 1";
        String address2 = "Test address 2";
        String address3 = "Test address 3";
        PlaceCreationRequest placeCreationRequest1 = new PlaceCreationRequest(address1);
        PlaceCreationRequest placeCreationRequest2 = new PlaceCreationRequest(address2);
        PlaceCreationRequest placeCreationRequest3 = new PlaceCreationRequest(address3);

        HttpEntity<PlaceCreationRequest> request1 = new HttpEntity<>(placeCreationRequest1);
        restTemplate.postForEntity("/places", request1, String.class);

        HttpEntity<PlaceCreationRequest> request2 = new HttpEntity<>(placeCreationRequest2);
        restTemplate.postForEntity("/places", request2, String.class);

        HttpEntity<PlaceCreationRequest> request3 = new HttpEntity<>(placeCreationRequest3);
        restTemplate.postForEntity("/places", request3, String.class);

        ResponseEntity<String> responce = restTemplate.getForEntity("/places", String.class);

        List<Place> actual = objectMapper.readValue(responce.getBody(), new TypeReference<List<Place>>() {
        });

        assertEquals("address1 not equal", address1, actual.get(0).getAddress());
        assertEquals("address2 not equal", address2, actual.get(1).getAddress());
        assertEquals("address3 not equal", address3, actual.get(2).getAddress());
        assertNotEquals("addresses should not be equal", "unknown", actual.get(2).getAddress());
    }
}
