package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.model.Student;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/listCourse")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping("/Course/{id}")
    public Course getCourse(@PathVariable Integer id){
        return (Course) courseRepository.findById(id).get();
    }

    @DeleteMapping("/Course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    @PostMapping("/Course")
    public List<Course> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return courseRepository.findAll();
    }

    @PutMapping("/Course/{id}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer id) {
        Course courseObj = (Course) courseRepository.findById(id).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setDescription(course.getDescription());
        Object CourseObj;
        courseRepository.save(courseObj);
        return courseRepository.findAll();
    }

}
