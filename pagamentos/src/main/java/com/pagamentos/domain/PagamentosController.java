package com.pagamentos.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentos.domain.dto.PagamentoDto;
import com.pagamentos.domain.dto.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/{idPedido}")
    public ResponseEntity<?> pagar(@PathVariable(name = "idPedido") Integer id, @RequestBody PagamentoDto pagamento) {
	Pedidos pedido;
	try {
	    pedido = pagamentoService.executarPagamento(id, pagamento);
	} catch (Exception e) {
	    return ResponseEntity.internalServerError().body(e.getMessage());
	}
	return ResponseEntity.ok(pedido);
    }
}
