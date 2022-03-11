package xyz.carn.eventifier.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import xyz.carn.eventifier.model.Organizer;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.service.OrganizerService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(OrganizerController.class)
public class OrganizerControllerTests {
    private final ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrganizerService service;

    public OrganizerControllerTests() {
        mapper = new ObjectMapper().findAndRegisterModules();
    }

    @Test
    public void testRegister() throws Exception {
        //Arrange
        Organizer expected = new Organizer();
        expected.setId(1);
        when(service.register(any())).thenReturn(expected);

        //Act
        MvcResult result = mockMvc.perform(post("/organizer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(expected)))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        var actual = mapper.readValue(result.getResponse().getContentAsString(), Organizer.class);
        assertThat(actual.getId()).isGreaterThan(0);
    }

    @Test
    public void testLogin() throws Exception {
        //Arrange
        User credentials = new User();
        credentials.setEmail("organizer@example.com");

        Organizer expected = new Organizer();
        expected.setEmail(credentials.getEmail());

        when(service.login(any())).thenReturn(Optional.of(expected));

        //Act
        MvcResult result = mockMvc.perform(post("/organizer/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(credentials)))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        var actual = mapper.readValue(result.getResponse().getContentAsString(), Organizer.class);
        assertThat(actual).isEqualTo(expected);
    }
}
