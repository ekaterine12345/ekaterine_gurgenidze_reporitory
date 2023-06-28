package com.exam.ekaterine_gurgenidze.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.channels.FileLock;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MANAGER")
public class Manger extends AppEntity<Long>{
    @Id
    @Column(name = "Id")
    @SequenceGenerator(name = "managerIdSeq", sequenceName = "MANAGER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managerIdSeq")
    private Long Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private Float salary;

    @OneToOne
    private Hotel hotel;
}
