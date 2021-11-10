package com.example.universitas.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "jurusan")
public class Jurusan implements Serializable {

    @Id
    @GeneratedValue(generator = "jurusan_seq")
    @GenericGenerator(
            name = "jurusan_seq",
            parameters = @Parameter(name = "prefix", value = "PRODI"),
            strategy = "com.example.universitas.util.DataIdGenerator"
    )
    @Column(name = "jurusan_id")
    private String id;

    @Column(name = "nama_jurusan", nullable = false, unique = true)
    private String namaJurusan;

    @Column(name = "kode_jurusan", nullable = false, unique = true)
    private String kodeJurusan;

    @ManyToOne(targetEntity = Fakultas.class, cascade = CascadeType.ALL)
    @JoinColumn (name = "fakultas_id")
    private Fakultas fakultas;

    public Fakultas getFakultas() {
        return fakultas;
    }


    
}
