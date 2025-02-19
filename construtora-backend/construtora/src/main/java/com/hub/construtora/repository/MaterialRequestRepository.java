package com.hub.construtora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hub.construtora.MaterialRequest;

public interface MaterialRequestRepository extends JpaRepository<MaterialRequest, Long> {
    List<MaterialRequest> findByStatus(String status); // Busca pedidos por status
}