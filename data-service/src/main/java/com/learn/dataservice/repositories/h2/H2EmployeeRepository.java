package com.learn.dataservice.repositories.h2;

import com.learn.dataservice.model.h2.H2Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2EmployeeRepository extends JpaRepository<H2Employee,Integer> {
}
