package backend.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.models.Applications;
import backend.backend.repository.ApplicationRepository;
import backend.backend.service.IApplicationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationsServiceImpl implements IApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Applications createNew(Applications app) {
        return applicationRepository.save(
                Applications.builder()
                        .name(app.getName())
                        .race(app.getRace())
                        .notes(app.getNotes())
                        .reason(app.getReason())
                        .school(app.getSchool())
                        .build());
    }

    @Override
    public List<Applications> getAllApps() {
        List<Applications> apps = applicationRepository.findAll();
        return apps;
    }

    @Override
    public boolean deleteById(Long appId) {
        applicationRepository.deleteById(appId);
        if(applicationRepository.findById(appId).isEmpty())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

}
