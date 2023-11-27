package backend.backend.service.impl;

import java.util.List;

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
                        .build());
    }

    @Override
    public List<School> getAllSchools() {
        List<School> schools = schoolRepository.findAll();
        return schools;
    }

}
