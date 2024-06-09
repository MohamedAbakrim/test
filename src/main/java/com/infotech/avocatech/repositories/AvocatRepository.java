package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Avocat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvocatRepository extends JpaRepository<Avocat, Integer> {

    List<Avocat> findAvocatsByNomContaining(String name);
}
