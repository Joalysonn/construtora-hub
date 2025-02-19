package com.hub.construtora;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "usuarios") // Renomeia a tabela para "usuarios"
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role; // OPERARIO, ENGENHEIRO

    // Relacionamento com MaterialRequest (pedidos feitos pelo usuário)
    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MaterialRequest> pedidosFeitos;

    // Relacionamento com MaterialRequest (pedidos aprovados pelo engenheiro)
    @OneToMany(mappedBy = "aprovador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MaterialRequest> pedidosAprovados;
}

