package com.learn.dataservice.repositories.postgres;

import com.learn.dataservice.model.postgres.PostgresEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresEmployeeRepository extends JpaRepository<PostgresEmployee,Integer> {
}
