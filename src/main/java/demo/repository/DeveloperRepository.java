package demo.repository;

import demo.model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer,Long>  {
    List<Developer> findBySurename(@Param("surename") String surename);

    List<Developer> findByNameAndSurename(@Param("name") String name,
            @Param("surename") String surename);
    List<Developer> findByDateIncorporationBetween(@Param("start") Date start,
            @Param("end") Date end);
}
