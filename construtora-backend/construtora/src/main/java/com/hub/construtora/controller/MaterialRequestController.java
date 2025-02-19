package com.hub.construtora.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hub.construtora.MaterialRequest;
import com.hub.construtora.service.MaterialRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
public class MaterialRequestController {

    @Autowired
    private MaterialRequestService materialRequestService;

    @PostMapping
    public MaterialRequest criarPedido(@RequestParam Long operarioId, @RequestParam Long materialId, @RequestParam BigDecimal quantidade) {
        return materialRequestService.criarPedido(operarioId, materialId, quantidade);
    }

    @GetMapping("/pendentes")
    public List<MaterialRequest> listarPedidosPendentes() {
        return materialRequestService.listarPedidosPendentes();
    }
}




