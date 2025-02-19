package com.hub.construtora;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

@Table(name = "pedidos_materiais") // Nome da tabela no banco de dados
public class MaterialRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com User (solicitante do pedido)
    @ManyToOne
    @JoinColumn(name = "solicitante_id", nullable = false) // Nome da coluna no banco de dados
    private User solicitante;

    // Relacionamento com Material (material solicitado)
    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false) // Nome da coluna no banco de dados
    private Material material;

    private BigDecimal quantidade; // Quantidade solicitada

    private LocalDateTime dataSolicitacao; // Data do pedido

    private String status; // PENDENTE, APROVADO, NEGADO

    // Relacionamento com User (engenheiro que aprovou o pedido)
    @ManyToOne
    @JoinColumn(name = "aprovador_id") // Nome da coluna no banco de dados
    private User aprovador;
}
