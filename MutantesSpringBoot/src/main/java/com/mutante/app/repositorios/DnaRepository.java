package com.mutante.app.repositorios;

import com.mutante.app.entidades.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {
    @Query("SELECT d FROM Dna d WHERE d.dna = :dnaString")
    Optional<Dna> findByDna(@Param("dnaString")String dnaString);
}
