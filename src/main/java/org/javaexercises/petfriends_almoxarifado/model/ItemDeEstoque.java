package org.javaexercises.petfriends_almoxarifado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDeEstoque {
    private String produtoId;
    private int saldoEmEstoque;
    private int pontoDeRessuprimento;
    private int estoqueMaximo;
    private Dimensoes dimensoes;
}

