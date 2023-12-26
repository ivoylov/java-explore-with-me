package ru.practicum.mainservice.location;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long>,
        JpaSpecificationExecutor<LocationEntity> {

    Optional<LocationEntity> findByIdAndStatus(long id, LocationStatus status);

    void deleteByIdAndStatus(long id, LocationStatus status);

    List<LocationEntity> findAllByStatus(LocationStatus status, Pageable pageable);

}
