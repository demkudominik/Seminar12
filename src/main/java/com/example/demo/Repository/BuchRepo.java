package com.example.demo.Repository;

import com.example.demo.Model.Buch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuchRepo extends JpaRepository<Buch, Integer> {
}
