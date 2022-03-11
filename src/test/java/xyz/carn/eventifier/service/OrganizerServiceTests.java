package xyz.carn.eventifier.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.carn.eventifier.model.Organizer;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.OrganizerRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrganizerServiceTests {

    @Mock
    private OrganizerRepository repository;

    @InjectMocks
    private OrganizerService service;

    @Test
    public void testRegister() {
        //Arrange
        Organizer expected = new Organizer();
        expected.setId(1);

        when(repository.save(any())).thenReturn(expected);

        //Act
        var returned = service.register(expected);

        //Assert
        assertThat(returned.getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testLogin() {
        //Arrange
        User credentials = new User();
        credentials.setEmail("organizer@example.com");
        credentials.setPassword("Password1");

        Organizer expected = new Organizer();
        expected.setEmail(credentials.getEmail());
        expected.setPassword(credentials.getPassword());

        when(repository.findByEmailAndPassword(any(), any())).thenReturn(Optional.of(expected));

        //Act
        var returned = service.login(credentials);

        //Assert
        assertThat(returned).isEqualTo(Optional.of(expected));
    }
}
