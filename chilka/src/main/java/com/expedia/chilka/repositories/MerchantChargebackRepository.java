package com.expedia.chilka.repositories;

import com.expedia.chilka.entities.Dispute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MerchantChargebackRepository extends JpaRepository<Dispute, Integer> {

    Integer countAllByCreateDateBetweenAndDisputeClientIdAndMatchingSourceId(Date start, Date finish, Integer disputeClientId, Integer matchingSourceId);

    Integer countAllByCreateDateBetweenAndAcquiringBankId(Date start, Date finish, Integer acquiringBankId);

    List<Dispute> findAllByCreateDateBetween(Date first, Date second);
}
