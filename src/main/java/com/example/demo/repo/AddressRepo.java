package com.example.demo.repo;

import com.example.demo.model.entity.AddressEntity;
import com.example.demo.model.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findAllByContactEntityId(Long id);
    void deleteAllByContactEntity(ContactEntity contactEntity);
}
