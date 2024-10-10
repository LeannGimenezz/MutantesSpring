package com.mutante.app.controladores;

import com.mutante.app.dtos.DnaRequest;
import com.mutante.app.servicios.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/mutant")
@RequiredArgsConstructor
public class DnaController {

    private final DnaService dnaService;

    @PostMapping("/test")
    public ResponseEntity<?> testDna(@RequestBody DnaRequest dnaRequest){
        if(dnaService.validDna(dnaRequest.getDna())){
            boolean res = dnaService.testDna(dnaRequest.getDna());
            if (res){
                return ResponseEntity.ok(res);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es un mutante");
        }
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Dna incorrecto");
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(){
        return ResponseEntity.ok(dnaService.getStats());
    }
}
