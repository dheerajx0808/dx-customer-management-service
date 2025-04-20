package com.prepx.work.repository;

import com.prepx.work.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    @Query("SELECT c FROM CustomerAccount c WHERE c.createdTs > :lastModifiedDate OR c.updatedTs > :lastModifiedDate")
    List<CustomerAccount> findModifiedAfter(LocalDateTime lastModifiedDate);
}