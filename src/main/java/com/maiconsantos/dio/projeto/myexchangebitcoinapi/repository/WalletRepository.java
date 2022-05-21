package com.maiconsantos.dio.projeto.myexchangebitcoinapi.repository;

import com.maiconsantos.dio.projeto.myexchangebitcoinapi.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet,Long> {
}
