package backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.models.School;
import backend.backend.service.ISchoolService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/School")
@RequiredArgsConstructor
public class SchoolController {
    
    @Autowired
    private ISchoolService schoolService;

    @PostMapping("New")
    @ResponseStatus(HttpStatus.CREATED)
    public School createNew(@RequestBody School school) {
        return schoolService.createNew(school);
    }

    @GetMapping("GetAll")
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

}
