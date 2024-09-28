package com.pagamentos.domain.dto;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagamentos.domain.Pedidos;
import com.pagamentos.domain.PedidosRepository;
import com.pagamentos.domain.StatusPagamento;
import com.pagamentos.domain.TipoPagamento;

@Service
public class PagamentoService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public Pedidos executarPagamento(Integer idPedido, PagamentoDto pagamentoDto) throws Exception {
	Optional<Pedidos> pedidoOpt = pedidosRepository.findById(idPedido);
	try {
	    if (pedidoOpt.isPresent()) {
		Pedidos pedido = pedidoOpt.get();
		double precoPedido = parse(pedido.getPreco(), Locale.FRANCE);
		double valorPagamento = parse(pagamentoDto.getValor(), Locale.FRANCE);
		if(valorPagamento < precoPedido) {
		    pedido.setStatus(StatusPagamento.CANCELADO);
		} else {
		    pedido.setStatus(TipoPagamento.getstatus(pagamentoDto.getTipoPagamento()));
		    pedido.setPagamento(true);
		}
		pedidosRepository.save(pedido);
		return pedido;
	    } else {
		throw new Exception("Pedido não localizado");
	    }
	} catch (ParseException e) {
	    throw new Exception("Não foi possível realizar o pagamento");
	}
    }

    public static double parse(final String amount, final Locale locale) throws ParseException {
	return Double.parseDouble(amount.replace(".", "").replace(",", "."));
    }
}
