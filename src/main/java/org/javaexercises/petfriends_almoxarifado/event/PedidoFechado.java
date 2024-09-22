package org.javaexercises.petfriends_almoxarifado.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class PedidoFechado implements Serializable {
    private Long pedidoId;
    private Date momentoFechamento;
}
