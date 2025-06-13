package br.com.store.api.observer;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppService implements Observer { // Observer concreto

    @Override
    public void update(Pedido pedido) {
        enviarNotificacaoCliente(pedido);
    }

    private void enviarNotificacaoCliente(Pedido pedido) {
        // Simula o envio de uma notificação para o cliente
        System.out.println("WHATSAPP: Olá! O status do seu pedido #" + pedido.getId() + " foi atualizado para: " + pedido.getStatus());
    }
}