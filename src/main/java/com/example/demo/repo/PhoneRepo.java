package com.example.demo.repo;

import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("phone_entity")
public interface PhoneRepo extends JpaRepository<PhoneEntity, Long> {
    List<PhoneEntity> findByContactEntityId(Long id);
    List<PhoneEntity> findAllByPhone(String phoneNumber);
    void deleteAllByContactEntity(ContactEntity contactEntity);
}
