package com.dot.DoT.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.dot.DoT.model.enums.Enums.EntryStatus;
import com.dot.DoT.model.enums.Enums.EntryType;



public class DoTModel {
    private Long id;
    private final Long userId;
    private String content;
    private final EntryType tipo;
    private EntryStatus status;
    private final LocalDate dataReferencia;
    private final LocalDateTime criadoEm;

    public DoTModel(
        Long id,
        Long userId,
        String content,
        EntryType tipo,
        EntryStatus status,
        LocalDate dataReferencia,
        LocalDateTime criadoEm
    ){
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.content = Objects.requireNonNull(content);
        this.tipo = Objects.requireNonNull(tipo);
        this.status = EntryStatus.INCOMPLETO;
        this.dataReferencia = Objects.requireNonNull(dataReferencia);
        this.criadoEm = LocalDateTime.now();
    }

    public void  concluir(){
        if (status == EntryStatus.CANCELADO){
            throw new IllegalStateException("Projeto cancelado, não pode ser concluído");
        }
        this.status = EntryStatus.CONCLUIDO;
    }

    public void cancelar (){
        if (status == EntryStatus.CONCLUIDO){
            throw new IllegalStateException("Projeto concluído, não pode ser cancelado");
        }
        this.status = EntryStatus.CANCELADO;
    }
    public void marcarComoMigrada(LocalDate newDate){
        if (status != EntryStatus.INCOMPLETO){
            throw new IllegalStateException("Apenas projetos incompletos podem ser migrados");
        }
        this.status = EntryStatus.MIGRADO;
    }

        public Long getId() {
            return id;
        }

        public Long getUserId() {
            return userId;
        }

        public EntryType getTipo() {
            return tipo;
        }

        public EntryStatus getStatus() {
            return status;
        }

        public String getContent() {
            return content;
        }

        public LocalDate getDataReferencia() {
            return dataReferencia;
        }

        public LocalDateTime getCriadoEm() {
            return criadoEm;
        }


    
}

