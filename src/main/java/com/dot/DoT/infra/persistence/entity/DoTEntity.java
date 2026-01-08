package com.dot.DoT.infra.persistence.entity;


import com.dot.DoT.model.enums.Enums.EntryStatus;
import com.dot.DoT.model.enums.Enums.EntryType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="DoT")
public class DoTEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryType tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryStatus status;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDate dataReferencia;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    protected DoTEntity(){

    }


    public DoTEntity(
        Long id,
        long userId,
        EntryType tipo,
        EntryStatus status,
        String content,
        LocalDate dataReferencia,
        LocalDateTime criadoEm
    ){
        this.id = id;
        this.userId = userId;
        this.tipo = tipo;
        this.status = status;
        this.content = content;
        this.dataReferencia = dataReferencia;
        this.criadoEm = criadoEm;
    }


    public Long getId() {
        return id;
    }


    public long getUserId() {
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
