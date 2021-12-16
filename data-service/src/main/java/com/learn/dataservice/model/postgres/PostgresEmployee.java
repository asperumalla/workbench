package com.learn.dataservice.model.postgres;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "postgresEmployee")
public class PostgresEmployee {

    @Id
    private int id;
    private String name;
}
