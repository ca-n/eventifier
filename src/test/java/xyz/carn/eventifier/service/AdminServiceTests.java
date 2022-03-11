package xyz.carn.eventifier.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.carn.eventifier.model.Admin;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.AdminRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTests {

    @Mock
    private AdminRepository repository;

    @InjectMocks
    private AdminService service;

    @Test
    public void testLogin() {
        //Arrange
        User credentials = new User();
        credentials.setEmail("admin@example.com");
        credentials.setPassword("Password1");

        Admin expected = new Admin();
        expected.setEmail(credentials.getEmail());
        expected.setPassword(credentials.getPassword());

        when(repository.findByEmailAndPassword(any(), any())).thenReturn(Optional.of(expected));

        //Act
        var returned = service.login(credentials);

        //Assert
        assertThat(returned).isEqualTo(Optional.of(expected));
    }
}
