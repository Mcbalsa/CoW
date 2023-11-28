package backend.backend.service;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.backend.models.Applications;

@Service
public interface IApplicationService {
    Applications createNew(Applications applications);
    List<Applications> getAllApps();
    boolean deleteById(Long appId);
}
