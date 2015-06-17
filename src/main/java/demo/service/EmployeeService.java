package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DeveloperRepository developerRepository;

    public void testEmployees(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();
        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date dateIncorporation = calendar.getTime();


        Employee employee = new Employee();
        employee.setName("Carlos");
        employee.setSurename("Mendez");
        employee.setSalary(1000.0);
        employee.setDateIncorporation(new Date());

        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("Jose");
        employee2.setSurename("Locario");
        employee2.setSalary(2000.0);
        employee2.setDateIncorporation(dateIncorporation);

        employeeRepository.save(employee2);
        Employee employee3 = new Employee();
        employee3.setName("Dario");
        employee3.setSurename("West");
        employee3.setSalary(5000.0);
        employee3.setDateIncorporation(new Date());

        employeeRepository.save(employee3);
        Employee mendez = employeeRepository.findBySurename("Mendez").get(0);
        Employee jose = employeeRepository.findByDateIncorporationBetween(startDate,endDate).get(0);

        System.out.println(mendez);
        System.out.println(jose);


    }
    public void testDevelopers(){
        Developer developer = new Developer();
        developer.setName("Juan");
        developer.setSurename("Fernandez");
        developer.setSalary(1000.0);
        developer.setDateIncorporation(new Date());
        developer.setCategory(Category.JUNIOR);
        developerRepository.save(developer);

        Developer developer2 = new Developer();
        developer2.setName("Pepe");
        developer2.setSurename("García");
        developer2.setSalary(3000.0);
        developer2.setDateIncorporation(new Date());
        developer2.setCategory(Category.SENIOR);
        developerRepository.save(developer2);

        Developer developer3 = new Developer();
        developer3.setName("Mario");
        developer3.setSurename("Mendez");
        developer3.setSalary(25000.0);
        developer3.setDateIncorporation(new Date());
        developer3.setCategory(Category.ARCHITECT);
        developerRepository.save(developer3);
    }

}
