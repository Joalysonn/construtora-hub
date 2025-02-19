package com.hub.construtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hub.construtora.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}