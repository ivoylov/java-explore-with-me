package ru.practicum.mainservice.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.models.event.Event;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "explore_with_me_users", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    @OneToMany(targetEntity = Event.class, mappedBy = "initiator", fetch = FetchType.LAZY)
    List<Event> events;

    @Override
    public String toString() {
        return String.format("id=%d, name=%s, email=%s",
                id, name, email);
    }

}
