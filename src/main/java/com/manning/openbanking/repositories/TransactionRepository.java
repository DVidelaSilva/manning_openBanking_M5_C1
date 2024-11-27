package com.manning.openbanking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.openbanking.entities.Transaction;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

    List<Transaction> findAllByAccountNumber(Integer accountNumber);


    // query obtener todos los numeros de cuenta
    @Query("SELECT DISTINCT t.accountNumber FROM Transaction t")
    List<Integer> findAllAccountNumbers();

}
