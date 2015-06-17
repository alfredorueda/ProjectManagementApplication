package demo.repository;

import demo.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 16/06/2015.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
        List<Employee> findBySurename(@Param("surename") String surename);

    List<Employee> findByNameAndSurename(@Param("name") String name,
                                         @Param("surename") String surename);
    List<Employee> findByDateIncorporationBetween(@Param("start") Date start,
                                                  @Param("end") Date end);
}
