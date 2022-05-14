package xyz.carn.eventifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.carn.eventifier.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
