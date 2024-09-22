package org.javaexercises.petfriends_almoxarifado.message;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.javaexercises.petfriends_almoxarifado.event.PedidoFechado;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PedidoFechadoDeserializer extends StdDeserializer<PedidoFechado> {

    public PedidoFechadoDeserializer() {
        super(PedidoFechado.class);
    }

    @Override
    public PedidoFechado deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        PedidoFechado evento = null;

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        SimpleDateFormat formatoDataSimples = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        try {
            evento = new PedidoFechado(
                    node.get("pedidoId").asLong(),
                    formatoDataSimples.parse(node.get("momentoFechamento").asText())
            );
        } catch (ParseException e) {
            throw new IOException("Formato de datos invalido", e);
        }

        return evento;
    }
}
