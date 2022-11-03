package com.example.mystock.Repo;

import com.example.mystock.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
}