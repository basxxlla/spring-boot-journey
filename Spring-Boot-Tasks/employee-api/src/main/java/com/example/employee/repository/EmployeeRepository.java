package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ---------- 1. Derived Query / "Function Name" ----------
    // Spring Data parses the method name itself and builds the query for you.
    // Matches names starting with the given prefix, e.g. "ahmed" -> "ahmed%".
    List<Employee> findByNameStartingWith(String name);

    // ---------- 2. Native Query (raw SQL, DB-specific) ----------
    @Query(value = "SELECT * FROM employee WHERE name LIKE CONCAT(:name, '%')", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("name") String name);

    // ---------- 3. Non-Native Query / JPQL (queries the entity, not the table) ----------
    @Query("SELECT e FROM Employee e WHERE e.name LIKE CONCAT(:name, '%')")
    List<Employee> searchByNameJPQL(@Param("name") String name);
}
