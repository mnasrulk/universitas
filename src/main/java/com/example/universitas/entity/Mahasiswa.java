package com.example.universitas.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @GeneratedValue(generator = "mahasiswa_seq")
    @GenericGenerator(
            name = "mahasiswa_seq",
            parameters = @Parameter(name = "prefix", value = "MHS"),
            strategy = "com.example.universitas.util.DataIdGenerator"
    )
    @Column(name = "mahasiswa_id")
    private String id;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;

    @Column(name = "npm", length = 12, unique = true)
    private String npm;

    @ManyToOne(targetEntity = Fakultas.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fakultas_id")
    private Fakultas fakultas;

    @ManyToOne(targetEntity = Jurusan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "jurusan_id")
    private Jurusan jurusan;
}
