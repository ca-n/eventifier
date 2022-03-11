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
import xyz.carn.eventifier.model.Admin;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.service.AdminService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AdminController.class)
public class AdminControllerTests {
    private final ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService service;

    public AdminControllerTests() {
        mapper = new ObjectMapper().findAndRegisterModules();
    }

    @Test
    public void testLogin() throws Exception {
        //Arrange
        User credentials = new User();
        credentials.setEmail("admin@example.com");

        Admin expected = new Admin();
        expected.setEmail(credentials.getEmail());

        when(service.login(any())).thenReturn(Optional.of(expected));

        //Act
        MvcResult result = mockMvc.perform(post("/admin/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(credentials)))
                .andReturn();

        //Assert
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        var actual = mapper.readValue(result.getResponse().getContentAsString(), Admin.class);
        assertThat(actual).isEqualTo(expected);
    }

}
