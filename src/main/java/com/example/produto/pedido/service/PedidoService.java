package com.example.produto.pedido.service;

import com.example.produto.pedido.entity.Pedido;
import com.example.produto.pedido.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criar(Pedido pedido) {
        // Ignora id vindo do JSON para evitar sobrescrita acidental do registro.
        pedido.setId(null);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public boolean deletarPorId(Long id) {
        if (!pedidoRepository.existsById(id)) {
            return false;
        }
        pedidoRepository.deleteById(id);
        return true;
    }
}

