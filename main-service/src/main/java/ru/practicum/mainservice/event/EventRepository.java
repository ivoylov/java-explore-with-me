package ru.practicum.mainservice.event;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.practicum.mainservice.user.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    List<Event> findEventsByUser(User user, Pageable pageable);

    Optional<Event> findFirstByIdAndUserId(long eventId, long userId);

    Optional<Event> findFirstByIdAndState(long id, EventState state);

    Set<Event> findAllByIdIn(Set<Long> events);
}
