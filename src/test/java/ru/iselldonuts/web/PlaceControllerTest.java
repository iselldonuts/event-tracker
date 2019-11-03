package ru.iselldonuts.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import ru.iselldonuts.MockConfig;
import ru.iselldonuts.repository.PlaceRepository;
import ru.iselldonuts.web.dto.PlaceCreationRequest;

import static org.springframework.test.util.AssertionErrors.assertNotEquals;


@ContextConfiguration(classes = MockConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

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

        HttpEntity<PlaceCreationRequest> request1 = new HttpEntity<>(placeCreationRequest1);

        ResponseEntity<String> companyCreateResponse1 = restTemplate.postForEntity("/places", request1, String.class);

        HttpEntity<PlaceCreationRequest> request2 = new HttpEntity<>(placeCreationRequest2);

        ResponseEntity<String> companyCreateResponse2 = restTemplate.postForEntity("/places", request2, String.class);

        HttpEntity<PlaceCreationRequest> request3 = new HttpEntity<>(placeCreationRequest3);

        ResponseEntity<String> companyCreateResponse3 = restTemplate.postForEntity("/places", request3, String.class);


        ResponseEntity<String> places = restTemplate.getForEntity("/places", String.class);

        assertNotEquals("get response should not be empty", "[]", places.getBody());
    }
}
