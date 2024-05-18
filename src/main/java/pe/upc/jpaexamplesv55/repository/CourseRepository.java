package pe.upc.jpaexamplesv55.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.jpaexamplesv55.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByName(String name);

    List<Course> findAllByCapacityGreaterThanEqual(int capacity);

    @Query("SELECT c FROM Course c WHERE c.id = ?1")
    Course findById(int id);

    @Query("SELECT c FROM Course c WHERE c.id = :idValue")
    Course findByIdNamed(@Param("idValue") int id);

    @Query(value = "SELECT * FROM COURSE WHERE COURSE.ID = :idValue", nativeQuery = true)
    Course findByIdNative(@Param("idValue") int id);

    @Query("SELECT c FROM Course c")
    List<Course> findAllAndSort(Sort sort);


}
