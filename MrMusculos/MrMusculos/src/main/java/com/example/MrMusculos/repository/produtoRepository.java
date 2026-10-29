package com.example.MrMusculos.repository;

import com.example.MrMusculos.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface produtoRepository extends JpaRepository<produto, Integer> {

    Optional<produto> findById(Integer Id);

    Optional<produto> findByAllId(Integer Id);

}
