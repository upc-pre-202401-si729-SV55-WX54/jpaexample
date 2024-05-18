package pe.upc.jpaexamplesv55.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.jpaexamplesv55.model.Course;
import pe.upc.jpaexamplesv55.service.CourseService;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course")
    List<Course> findAllAndSort(){
        return courseService.findAllAndSort();
    }

    @GetMapping("/course/{id}")
    Course findById(@PathVariable("id") int id){
        return courseService.findById(id);
    }

    @GetMapping("/course/name/{name}")
    Course getByName(@PathVariable("name") String name){
        return courseService.getByName(name);
    }

    @GetMapping("/course/capacity/{capacity}")
    List<Course> findAllByCapacityGreaterThanEqual(@PathVariable("capacity") int capacity){
        return courseService.findAllByCapacityGreaterThanEqual(capacity);
    }




}
