package com.mutante.app.servicios;

import com.mutante.app.entidades.Dna;
import com.mutante.app.entidades.Stats;
import com.mutante.app.repositorios.DnaRepository;
import com.mutante.app.repositorios.StatsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DnaServiceImpl implements DnaService {

    private final DnaRepository dnaRepository;
    private final StatsRepository statsRepository;


    public boolean testDna(String[] dna) {

        // Realizar las pruebas para verificar si es mutante
        boolean isMutant = testRows(dna) || testColumn(dna) || testAllDiagonals(dna) || testInverseDiagonals(dna);

        // Guardar el nuevo ADN en la base de datos
        Dna newDna = new Dna(dna, isMutant);
        dnaRepository.save(newDna);

        return isMutant;
    }

    public static boolean validRow(String fila) {
        return fila.toLowerCase().matches("[acgt]+");
    }

    public boolean validDna(String[] dna) {
        for (String row : dna) {
            if (!validRow(row) || row.length() != dna.length) {
                return false;
            }
        }
        return true;
    }

    public static boolean testRows(String[] dna) {
        for (String row : dna) {
            if (hasConsecutiveChars(row)) {
                return true;
            }
        }
        return false;
    }

    public static boolean testColumn(String[] dna) {
        int n = dna.length;
        for (int i = 0; i < n; i++) {
            StringBuilder column = new StringBuilder();
            for (String row : dna) {
                column.append(row.charAt(i));
            }
            if (hasConsecutiveChars(column.toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean testAllDiagonals(String[] dna) {
        return checkDiagonals(dna, false);
    }

    public static boolean testInverseDiagonals(String[] dna) {
        return checkDiagonals(dna, true);
    }

    private static boolean checkDiagonals(String[] dna, boolean inverse) {
        int n = dna.length;

        for (int i = 0; i < n; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                diagonal.append(inverse ? dna[j].charAt(n - 1 - (i + j)) : dna[j].charAt(i + j));
            }
            if (hasConsecutiveChars(diagonal.toString())) {
                return true;
            }
        }

        for (int i = 1; i < n; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                diagonal.append(inverse ? dna[i + j].charAt(n - 1 - j) : dna[i + j].charAt(j));
            }
            if (hasConsecutiveChars(diagonal.toString())) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasConsecutiveChars(String sequence) {
        int count = 1;
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 1;
            }
        }
        return false;
    }

    public Stats getStats() {
        // Buscar las estadísticas actuales en la base de datos
        Optional<Stats> statsOptional = statsRepository.findById(Long.valueOf(1L));

        // Si ya existen estadísticas guardadas, devolverlas sin recalcular
        if (statsOptional.isPresent()) {
            return statsOptional.get();
        }

        // Si no existen estadísticas guardadas, calcularlas por primera vez
        Stats stats = new Stats();

        List<Dna> dnaList = dnaRepository.findAll();
        Long human = 0L;
        Long mutant = 0L;

        // Calcular el número de humanos y mutantes
        for (Dna dna : dnaList) {
            if (testDna(dna.getSequence())) {
                mutant += 1;
            } else {
                human += 1;
            }
        }

        // Calcular el ratio y evitar división por cero
        double ratio = human > 0 ? (double) mutant / human : 0.0;

        // Establecer los valores calculados en el objeto Stats
        stats.setHumans(human);
        stats.setMutants(mutant);
        stats.setRatio(ratio);

        // Guardar las estadísticas en la base de datos
        statsRepository.save(stats);

        // Devolver las estadísticas calculadas
        return stats;
    }

    public boolean existDna(String[] dna){
        String dnaString = String.join(",", dna);
        Optional<Dna> existDna = dnaRepository.findByDna(dnaString);
        if(existDna.isPresent()){
            return true;
        }
        return false;
    }

}