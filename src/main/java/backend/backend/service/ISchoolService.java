package backend.backend.service;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.backend.models.School;

@Service
public interface ISchoolService {
    School createNew(School school);
    School update(School school);
    List<School> getAllSchools();
    Boolean deleteById(Long schoolId);
}
