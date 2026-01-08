package com.dot.DoT.infra.persistence;

import com.dot.DoT.model.*;

import org.springframework.stereotype.Repository;
import com.dot.DoT.infra.persistence.entity.*;
import com.dot.DoT.repository.DoTRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.*;



@Repository
public class JpaDoTRepository implements DoTRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public DoTModel save(DoTModel dotmodel){
        DoTEntity entity = toDataBase(dotmodel);

        em.flush();
        return toDominio(entity);
    }

    @Override
    public Optional<DoTModel> findById(Long id){
            DoTEntity entity = em.find(DoTEntity.class, id);
            return entity == null ? Optional.empty() : Optional.of(toDominio(entity));
        }

        @Override
        public List<DoTModel> findByUserAndDate(Long userId, LocalDate date){
            return em.createQuery(
                "SELECT e FROM DoTEntity e WHERE e.userId = :userId AND e.referenceDate = :date",
                DoTEntity.class
            )
            .setParameter("userId", userId)
            .setParameter("date", date)
            .getResultList()
            .stream()
            .map(this::toDominio)
            .toList();
        }

        @Override
        public List<DoTModel> findByUserAndMonth(Long userId, int year, int month){
            return em.createQuery(
                "SELECT e FROM DoTEntity e WHERE e.userId = :userId AND YEAR(e.referenceDate) = :year AND MONTH(e.referenceDate) = :month",
                DoTEntity.class
            )
            .setParameter("userId", userId)
            .setParameter("year", year)
            .setParameter("month", month)
            .getResultList()
            .stream()
            .map(this::toDominio)
            .toList();
        }

private DoTEntity toDataBase(DoTModel dotmodel){
        return new DoTEntity(
            dotmodel.getId(),
            dotmodel.getUserId(),
            dotmodel.getTipo(),
            dotmodel.getStatus(),
            dotmodel.getContent(),
            dotmodel.getDataReferencia(),
            dotmodel.getCriadoEm()
        );
    }
    private DoTModel toDominio(DoTEntity dotentity){
        return new DoTModel(
            dotentity.getId(),
            dotentity.getUserId(),
            dotentity.getContent(),
            dotentity.getTipo(),
            dotentity.getStatus(),
            dotentity.getDataReferencia(),
            dotentity.getCriadoEm()
        );
    }


    }




























