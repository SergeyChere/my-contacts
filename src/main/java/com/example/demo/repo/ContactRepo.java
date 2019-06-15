package com.example.demo.repo;

import com.example.demo.model.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Long> {
    @Query("select contct.id from ContactEntity contct")
    List<Long> getAllContactsId();
    List<ContactEntity> findAllByFullName(String name);
}
