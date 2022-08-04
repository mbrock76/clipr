package com.clipr.users_stores.repository;

import com.clipr.users_stores.model.UserStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersStoresRepo extends JpaRepository<UserStore, Integer>{

    List<UserStore> findByuserId(int user_id);

    List<UserStore> findBystoreId(int store_id);

    void deleteAllByuserId(int user_id);

    void deleteAllBystoreId(int store_id);
}
