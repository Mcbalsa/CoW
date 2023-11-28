package backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.models.Applications;
import backend.backend.service.IApplicationService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/Applications")
@RequiredArgsConstructor
public class ApplicationsController {

    @Autowired
    private IApplicationService applicationService;

    @PostMapping("New")
    @ResponseStatus(HttpStatus.CREATED)
    public Applications createNew(@RequestBody Applications app) {
        return applicationService.createNew(app);
    }

    @GetMapping("GetAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Applications> getAllApps() {
        return applicationService.getAllApps();
    }

    @DeleteMapping("DeleteById")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteById(Long id) {
        return applicationService.deleteById(id);
    }
}
