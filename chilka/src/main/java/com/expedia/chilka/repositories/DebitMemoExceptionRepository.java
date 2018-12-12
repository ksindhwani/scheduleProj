package com.expedia.chilka.repositories;

import com.expedia.chilka.entities.DebitMemoException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;

@Repository
public interface DebitMemoExceptionRepository extends JpaRepository<DebitMemoException, BigInteger> {

    Integer countAllByCreateDateBetween(Date start, Date finish);

}
