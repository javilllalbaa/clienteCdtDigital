package com.mibanco.es.clienteCDTDigital.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "custom_param")
public class CustomParamEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreCustomParam;

}
