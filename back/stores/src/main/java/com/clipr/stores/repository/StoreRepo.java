package com.clipr.stores.repository;

import com.clipr.stores.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepo extends JpaRepository<Store, Integer> {

    List<Store> findByCompany(String company);
}
