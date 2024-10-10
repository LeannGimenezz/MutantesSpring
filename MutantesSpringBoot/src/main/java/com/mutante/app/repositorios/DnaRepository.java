package com.mutante.app.repositorios;

import com.mutante.app.entidades.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {
}
