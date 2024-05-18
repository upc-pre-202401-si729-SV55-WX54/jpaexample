package pe.upc.jpaexamplesv55.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.upc.jpaexamplesv55.model.Course;
import pe.upc.jpaexamplesv55.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course getByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> findAllByCapacityGreaterThanEqual(int capacity){
        return courseRepository.findAllByCapacityGreaterThanEqual(capacity);
    }

    public Course findById(int id) {
        return courseRepository.findByIdNative(id);
    }

    public List<Course> findAllAndSort() {
        return courseRepository.findAll(Sort.by("capacity"));
    }


}
