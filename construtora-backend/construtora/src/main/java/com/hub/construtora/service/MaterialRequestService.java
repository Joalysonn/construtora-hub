package com.hub.construtora.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hub.construtora.Material;
import com.hub.construtora.MaterialRequest;

import com.hub.construtora.User;
import com.hub.construtora.repository.MaterialRequestRepository;
import com.hub.construtora.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
public class MaterialRequestService {

    @Autowired
    private MaterialRequestRepository materialRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public MaterialRequest criarPedido(Long operarioId, Long materialId, BigDecimal quantidade) {
        User operario = userRepository.findById(operarioId).orElseThrow();
        MaterialRequest pedido =  new MaterialRequest();
        pedido.setSolicitante(operario);
        pedido.setQuantidade(quantidade);
        pedido.setDataSolicitacao(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        return materialRequestRepository.save(pedido);
    }

    public List<MaterialRequest> listarPedidosPendentes() {
        return materialRequestRepository.findByStatus("PENDENTE");
    }
}
