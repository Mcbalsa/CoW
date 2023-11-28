package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.models.Applications;

public interface ApplicationRepository extends JpaRepository<Applications, Long>{
    
}
