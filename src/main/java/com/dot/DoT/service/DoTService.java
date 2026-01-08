package com.dot.DoT.service;

import com.dot.DoT.model.DoTModel;
import com.dot.DoT.model.enums.Enums.EntryStatus;
import com.dot.DoT.model.enums.Enums.EntryType;
import com.dot.DoT.repository.DoTRepository;


import java.time.*;
import java.util.*;

import org.springframework.stereotype.Service;
@Service
public class DoTService {
    private final DoTRepository doTRepository;

    public DoTService(DoTRepository doTRepository){
        this.doTRepository = doTRepository;
    }

    public DoTModel createModel(
        Long id,
        Long userId,
        String content,
        EntryType type,
        EntryStatus status,
        LocalDate date,
        LocalDateTime upado
    ){
        DoTModel dotmodel = new DoTModel(
            null,
            userId,
            content,
            type,
            EntryStatus.INCOMPLETO,
            date,
            upado
        );
        return doTRepository.save(dotmodel);
    }

    public DoTModel concluir(Long id){
        DoTModel dotmodel = doTRepository.findById((Long)id).orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));
        
        dotmodel.concluir();
        return doTRepository.save(dotmodel);
    }

    public DoTModel marcarComoMigrada(Long id, LocalDate newDate){
        DoTModel dotmodel = doTRepository.findById((Long)id).orElseThrow(() -> new IllegalArgumentException("Projeto não encontrado"));

        dotmodel.marcarComoMigrada(newDate);
        return doTRepository.save(dotmodel);
    }
    public List<DoTModel> ListarPorDia(long userId, LocalDate date){
        return doTRepository.findByUserAndDate(userId, date);
    }
    public List<DoTModel> ListarPorMes(long userId, int year, int month){
        return doTRepository.findByUserAndMonth(userId, year, month);
    }

}
