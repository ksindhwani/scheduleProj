package com.expedia.chilka.repositories;

import com.expedia.chilka.entities.AutoImportException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AutoImportExceptionRepository extends JpaRepository<AutoImportException, Integer> {

    Integer countAllByCreateDateBetweenAndAcquiringBankId(Date start, Date finish, Integer acquiringBankId);

    List<AutoImportException> findAllByCreateDateBetween(Date first, Date second);
}
