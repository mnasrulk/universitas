package com.example.universitas.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fakultas")
public class Fakultas implements Serializable {

    @Id
    @GeneratedValue(generator = "fakultas_seq")
    @GenericGenerator(
            name = "fakultas_seq",
            parameters = @Parameter(name = "prefix", value = "FAK"),
            strategy = "com.example.universitas.util.DataIdGenerator"
    )
    @Column(name = "fakultas_id")
    private String id;

    @Column(name = "nama_fakultas", nullable = false, unique = true)
    private String namaFakultas;

    @Column(name = "kode_fakultas", nullable = false, unique = true)
    private String kodeFakultas;
}
