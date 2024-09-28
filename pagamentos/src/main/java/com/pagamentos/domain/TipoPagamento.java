package com.pagamentos.domain;

public enum TipoPagamento {
    CARTAO, PIX, BOLETO;

    public static StatusPagamento getstatus(TipoPagamento tipo) {
	switch (tipo) {
	case CARTAO:
	    return StatusPagamento.PAGO_CARTAO;
	case PIX:
	    return StatusPagamento.PAGO_PIX;
	case BOLETO:
	    return StatusPagamento.PAGO_BOLETO;
	default: return StatusPagamento.CANCELADO;
	}
    }
}
