package com.amalitech.payroll.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.util.UUID;

import java.util.UUID;

@Entity
@Data
public class Allowance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator",
//            parameters = {
//                    @Parameter(
//                            name = "uuid_gen_strategy_class",
//                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
//                    )
//            }
//    )
//    @org.hibernate.annotations.Type(value = "org.hibernate.type.UUIDCharType")
//    @Column(updatable = false, nullable = false)
    private Long id;
    @Column
    private String type;
    @Column
    private String description;
}
