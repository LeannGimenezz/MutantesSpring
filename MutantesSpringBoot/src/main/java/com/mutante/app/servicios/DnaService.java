package com.mutante.app.servicios;

import com.mutante.app.entidades.Dna;
import com.mutante.app.entidades.Stats;

import java.util.Optional;

public interface DnaService{
     boolean testDna(String[] dna);
     boolean validDna(String[] dna);
     Stats getStats();
     boolean existDna(String[] dna);
}
