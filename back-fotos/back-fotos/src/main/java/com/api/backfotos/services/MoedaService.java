package com.api.backfotos.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MoedaService {

    private BigDecimal valor;
    private static final String UNIDADE_MONETARIA = "R$";
    private static int CASAS_DECIMAIS = 2;
    private static final DecimalFormat FORMATADOR = new DecimalFormat(UNIDADE_MONETARIA + " #,###,##0.00");

    public MoedaService(String valor){
        this.valor = new BigDecimal(valor);
    }

    public void somar(String valor){
        this.valor = this.valor.add(new BigDecimal(valor));
    }

    public void subtrair(String valor){
      this.valor = this.valor.subtract(new BigDecimal(valor));
    }

    public void multiplicar(String valor){
        this.valor = this.valor.multiply(new BigDecimal(valor));
    }

    public void dividir(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("Não é possivel dividir por 0");
            //modificar para uma exeção
        }else{
            this.valor = this.valor.divide(valor, CASAS_DECIMAIS, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getValor(){
        return valor;
    }

    public String getValorFormatado(){
        return FORMATADOR.format(valor);
    }
}
