package com.dot.DoT.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dot.DoT.model.DoTModel;

public interface DoTRepository {

    DoTModel save(DoTModel dotmodel);

    Optional<DoTModel> findById(Long id);

    List<DoTModel> findByUserAndDate(Long userId, LocalDate date);

    List<DoTModel> findByUserAndMonth(Long userId, int year, int month);
}

