package com.example.universitas.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dosen")
public class Dosen implements Serializable {

    @Id
    @GeneratedValue(generator= "dosen_seq")
    @GenericGenerator(
            name = "dosen_seq",
            parameters = @Parameter(name = "prefix", value = "DSN"),
            strategy = "com.example.universitas.util.DataIdGenerator"
    )
    @Column(name = "dosen_id")
    private String id;

    @Column(name = "nama_dosen", nullable = false, unique = true)
    private String namaDosen;

    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @ManyToOne(targetEntity = Jurusan.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "jurusan_id")
    private Jurusan jurusan;

    @ManyToOne(targetEntity = Fakultas.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "fakultas_id")
    private Fakultas fakultas;
}
