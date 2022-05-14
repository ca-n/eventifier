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
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.service.ParticipantService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ParticipantController.class)
public class ParticipantControllerTests {
    private final ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParticipantService service;

    public ParticipantControllerTests() {
        mapper = new ObjectMapper().findAndRegisterModules();
    }

    @Test
    public void testRegister() throws Exception {
        //Arrange
        Participant expected = new Participant();
        expected.setId(1);
        when(service.register(any())).thenReturn(expected);

        //Act
        MvcResult result = mockMvc.perform(post("/participant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(expected)))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        var actual = mapper.readValue(result.getResponse().getContentAsString(), Participant.class);
        assertThat(actual.getId()).isGreaterThan(0);
    }

    @Test
    public void testLogin() throws Exception {
        //Arrange
        User credentials = new User();
        credentials.setId(1);

        Participant expected = new Participant();
        expected.setId(credentials.getId());

        when(service.login(any())).thenReturn(Optional.of(expected));

        //Act
        MvcResult result = mockMvc.perform(post("/participant/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(credentials)))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        var actual = mapper.readValue(result.getResponse().getContentAsString(), Participant.class);
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }
}
