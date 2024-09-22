package org.javaexercises.petfriends_almoxarifado.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.google.cloud.spring.pubsub.support.converter.ConvertedBasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import lombok.RequiredArgsConstructor;
import org.javaexercises.petfriends_almoxarifado.event.PedidoFechado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class AlmoxarifadoService {

    private static final Logger LOG = LoggerFactory.getLogger(AlmoxarifadoService.class);

    @Autowired
    private PubSubTemplate pubSubTemplate;
    @Autowired
    JacksonPubSubMessageConverter jacksonPubSubMessageConverter;

    @ServiceActivator(inputChannel = "inputMessageChannel")
    private void receber(PedidoFechado payloadPedidoFechado,
                         @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE)ConvertedBasicAcknowledgeablePubsubMessage<PedidoFechado> message) {

        LOG.info("========= Mensagem Recebida -----> " + payloadPedidoFechado);
        message.ack();
        this.processarPedidoFechado(payloadPedidoFechado);
    }

    private void processarPedidoFechado(PedidoFechado eventoPedidoFechado) {
        LOG.info("========= Iniciando Separação dos Itens do Pedido ID: -----> " + eventoPedidoFechado.getPedidoId());
    }
}

