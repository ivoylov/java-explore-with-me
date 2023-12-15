package ru.practicum.mainservice.api.privat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.mainservice.models.event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
