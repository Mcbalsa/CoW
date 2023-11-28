package backend.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import backend.backend.models.Teachers;

@Service
public interface ITeacherService {
    Teachers createNew(Teachers teacher);
    List<Teachers> getAllApps();
    boolean deleteById(Long appId);
}
