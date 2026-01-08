package com.dot.DoT.controller.dto;

import com.dot.DoT.model.enums.Enums.EntryType;

import java.time.LocalDate;

public record CreateDoTRequest(
    Long userId,
    String content,
    EntryType type,
    LocalDate date
) {}
    
