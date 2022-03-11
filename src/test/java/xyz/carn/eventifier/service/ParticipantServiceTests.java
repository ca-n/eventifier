package xyz.carn.eventifier.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.carn.eventifier.model.Participant;
import xyz.carn.eventifier.model.User;
import xyz.carn.eventifier.repository.ParticipantRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceTests {

    @Mock
    private ParticipantRepository repository;

    @InjectMocks
    private ParticipantService service;

    @Test
    public void testRegister() {
        //Arrange
        Participant expected = new Participant();
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
        credentials.setEmail("participant@example.com");
        credentials.setPassword("Password1");

        Participant expected = new Participant();
        expected.setEmail(credentials.getEmail());
        expected.setPassword(credentials.getPassword());

        when(repository.findByEmailAndPassword(any(), any())).thenReturn(Optional.of(expected));

        //Act
        var returned = service.login(credentials);

        //Assert
        assertThat(returned).isEqualTo(Optional.of(expected));
    }
}
