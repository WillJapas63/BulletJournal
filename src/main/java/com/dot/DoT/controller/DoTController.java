package com.dot.DoT.controller;

import com.dot.DoT.model.DoTModel;

import com.dot.DoT.service.*;
import com.dot.DoT.controller.dto.CreateDoTRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
@RestController
@RequestMapping("/dots")
public class DoTController {
    private final DoTService service;

    public DoTController(DoTService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DoTModel> create(@RequestBody CreateDoTRequest request){
        DoTModel created = service.createModel(
            null,
            request.userId(),
             request.content(),
              request.type(),
              null,
               request.date(),
               LocalDateTime.now()
            );

            return ResponseEntity.ok(created);
    }
    @PutMapping("/{id}/concluir")
    public ResponseEntity<DoTModel> concluir(@PathVariable Long id){
        return ResponseEntity.ok(service.concluir(id));
    }

    @GetMapping("/dia")
    public ResponseEntity<List<DoTModel>> ListarPorDia(
        @RequestParam long userId,
        @RequestParam LocalDate date
    ){
        return ResponseEntity.ok(service.ListarPorDia(userId, date));
    }

    @GetMapping("/mes")
    public ResponseEntity<List<DoTModel>> ListarPorMes(
        @RequestParam Long userId,
        @RequestParam int year,
        @RequestParam int month
    ) {
        return ResponseEntity.ok(service.ListarPorMes(userId, year, month));
    }


}
