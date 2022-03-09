package xyz.carn.eventifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.carn.eventifier.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
