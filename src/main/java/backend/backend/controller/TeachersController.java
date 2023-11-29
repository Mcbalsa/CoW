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

import backend.backend.models.Teachers;
import backend.backend.service.ITeacherService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/Teachers")
@RequiredArgsConstructor
public class TeachersController {

    @Autowired
    private ITeacherService teacherService;

    @PostMapping("New")
    @ResponseStatus(HttpStatus.CREATED)
    public Teachers createNew(@RequestBody Teachers teacher) {
        return teacherService.createNew(teacher);
    }

    @GetMapping("GetAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Teachers> getAllApps() {
        return teacherService.getAllApps();
    }

    @DeleteMapping("DeleteById")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteById(Long id) {
        return teacherService.deleteById(id);
    }
}
