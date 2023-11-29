package backend.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.models.Teachers;
import backend.backend.repository.TeacherRepository;
import backend.backend.service.ITeacherService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeachersService implements ITeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teachers createNew(Teachers teacher) {
        return teacherRepository.save(
            Teachers.builder()
                .name(teacher.getName())
                .race(teacher.getRace())
                .title(teacher.getTitle())
                .photoUrl(teacher.getPhotoUrl())
                .school(teacher.getSchool())
                .build());
    }

    @Override
    public List<Teachers> getAllApps() {
        List<Teachers> teachers = teacherRepository.findAll();

        return teachers;
    }

    @Override
    public boolean deleteById(Long appId) {
        teacherRepository.deleteById(appId);
        if(teacherRepository.findById(appId).isEmpty())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
