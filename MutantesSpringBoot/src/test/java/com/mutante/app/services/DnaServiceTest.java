package com.mutante.app.services;

import com.mutante.app.servicios.DnaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DnaServiceTest {

@InjectMocks
private DnaServiceImpl DnaServiceImpl;

    @Test
    public void testRows(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(com.mutante.app.servicios.DnaServiceImpl.testRows(dna));
    }

    @Test
    public void testColumn(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(DnaServiceImpl.testColumn(dna));
    }

    @Test
    public void testDiagonals(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(com.mutante.app.servicios.DnaServiceImpl.testAllDiagonals(dna));
    }

    @Test
    public void testInverseDiagonals(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(com.mutante.app.servicios.DnaServiceImpl.testInverseDiagonals(dna));
    }

    @Test
    public void testDna(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(DnaServiceImpl.validDna(dna));
    }
    @Test
    public void testInvalidDna() {
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTX", // 'X' es un carácter inválido
                "AGTCAC"
        };
        assertTrue(DnaServiceImpl.validDna(dna)); // Verifica que el ADN no sea válido
    }

    @Test
    public void testMutant1(){
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }

    @Test
    public void testMutant2(){
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }



    @Test
    public void testNonMutant1(){
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }

    @Test
    public void testNonMutant2(){
        String[] dna = {
            "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }

    @Test
    public void testMutant3(){
        String[] dna = {
                "TCGGTCGAT",
                "TGATCCTTT",
                "TAAGTGATA",
                "AAGTATGGC",
                "GGAGCAGTG",
                "AGATCAGCA",
                "CTAGGCCCA",
                "TGATGGTAC",
                "TGATGTATC"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }

    @Test
    public void testMutant4(){
        String[] dna = {
                "TTTTTTTT",
                "TTTTTTTT",
                "TTTTTTTT",
                "CCGGCCAA",
                "GGGGCCAA",
                "AAGGACTA",
                "AAGGGCAT",
                "CGGAGTCC"
        };
        assertTrue(DnaServiceImpl.testDna(dna));
    }




}
