package backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.models.Teachers;

public interface TeacherRepository extends JpaRepository<Teachers, Long>{
    
}
