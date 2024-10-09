package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;
    @Column(name = "name_direccion")
    private String nameDireccion;
    @Column(name = "calle")
    private String calle;
    @Column(name = "ciudad")
    private String ciudad;
    @OneToOne(mappedBy = "direccion")
    private Student student;
}
