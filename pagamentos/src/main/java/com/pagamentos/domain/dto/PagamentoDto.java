package com.pagamentos.domain.dto;

import com.pagamentos.domain.TipoPagamento;

public class PagamentoDto {

    private String valor;
    
    private TipoPagamento tipoPagamento;
    
    

    public PagamentoDto() {
	super();
    }

    public PagamentoDto(String valor, TipoPagamento tipoPagamento) {
	super();
	this.valor = valor;
	this.tipoPagamento = tipoPagamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
