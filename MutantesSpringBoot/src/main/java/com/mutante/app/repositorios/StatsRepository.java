package com.mutante.app.repositorios;

import com.mutante.app.entidades.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatsRepository extends JpaRepository<Stats,Long> {
    Optional<Stats> findById(Long id);
}
