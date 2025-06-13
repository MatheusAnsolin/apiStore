package br.com.store.api.observer;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements Observer { // Observer concreto

    @Override
    public void update(Pedido pedido) {
        enviarEmailCliente(pedido);
    }

    private void enviarEmailCliente(Pedido pedido) {
        // Simula o envio de um email para o cliente
        System.out.println("E-MAIL: Prezado cliente, o status do pedido #" + pedido.getId() + " agora é: " + pedido.getStatus());
    }
}