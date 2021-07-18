package com.zup.william.proposta.proposta.biometria;

import com.zup.william.proposta.proposta.novaProposta.NovaProposta;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Biometria implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String codigoBiometria;

    @NotNull
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    private NovaProposta dono;

    public Biometria(String codigoBiometria) {
        this.codigoBiometria = codigoBiometria;
    }

    public Biometria() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biometria biometria = (Biometria) o;
        return Objects.equals(id, biometria.id) && Objects.equals(codigoBiometria, biometria.codigoBiometria) && Objects.equals(dataCadastro, biometria.dataCadastro) && Objects.equals(dono, biometria.dono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBiometria, dataCadastro, dono);
    }

    @Override
    public int compareTo(Object o) {
        this.equals(o);
        return 0;
    }
}
