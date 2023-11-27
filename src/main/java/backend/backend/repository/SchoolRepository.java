package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.models.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
    
}
