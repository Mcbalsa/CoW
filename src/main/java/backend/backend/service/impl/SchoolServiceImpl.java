package backend.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.models.School;
import backend.backend.repository.SchoolRepository;
import backend.backend.service.ISchoolService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School createNew(School school) {
        return schoolRepository.save(
                School.builder()
                        .name(school.getName())
                        .city(school.getCity())
                        .province(school.getProvince())
                        .founder(school.getFounder())
                        .teachers(school.getTeachers())
                        .applications(school.getApplications())
                        .build());
    }

    @Override
    public School update(School school) {
        Optional<School> existingSchool = schoolRepository.findById(school.getSchoolId());
        if(existingSchool.isEmpty())
            throw new RuntimeException(String.format("No school found by id %", school.getSchoolId()));
        existingSchool.get().setName(school.getName());
        existingSchool.get().setCity(school.getCity());
        existingSchool.get().setProvince(school.getProvince());
        existingSchool.get().setFounder(school.getFounder());
        return schoolRepository.save(existingSchool.get());
    }

    @Override
    public List<School> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools;
    }

    @Override
    public Boolean deleteById(Long schoolId) {
        schoolRepository.deleteById(schoolId);
        if(schoolRepository.findById(schoolId).isEmpty())
            return Boolean.TRUE;
        return Boolean.FALSE;
            
        
    }

}
