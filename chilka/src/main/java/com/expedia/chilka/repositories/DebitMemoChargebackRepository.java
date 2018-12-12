package com.expedia.chilka.repositories;

import com.expedia.chilka.entities.DebitMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface DebitMemoChargebackRepository extends JpaRepository<DebitMemo, BigInteger> {

    Integer countAllByCreateDateBetweenAndDebitMemoTypeIdAndMatchingSourceId(Date start, Date finish, Integer debitMemoTypeId, Integer matchingSourceId);

    Integer countAllByCreateDateBetweenAndMatchingSourceId(Date start, Date finish, Integer matchingSourceId);

    Integer countAllByCreateDateBetween(Date start, Date finish);

}
