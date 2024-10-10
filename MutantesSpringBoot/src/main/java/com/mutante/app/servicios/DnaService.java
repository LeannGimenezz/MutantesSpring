package com.mutante.app.servicios;

import com.mutante.app.entidades.Stats;

public interface DnaService{
     boolean testDna(String[] dna);
     boolean validDna(String[] dna);
     Stats getStats();
}
