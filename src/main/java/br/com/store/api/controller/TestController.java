package br.com.store.api.controller;

import br.com.store.api.factory.CamisaFactory;
import br.com.store.api.factory.CanecaFactory;
import br.com.store.api.factory.ProdutoFactory;
import br.com.store.api.factory.produto.Produto;
import br.com.store.api.observer.EmailService;
import br.com.store.api.observer.Pedido;
import br.com.store.api.observer.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final WhatsAppService whatsAppService;
    private final EmailService emailService;

    // Injeção de dependência dos Observers (serviços do Spring)
    @Autowired
    public TestController(WhatsAppService whatsAppService, EmailService emailService) {
        this.whatsAppService = whatsAppService;
        this.emailService = emailService;
    }

    @GetMapping("/observer")
    public String testObserver() {
        // Cria o Subject (Pedido)
        Pedido pedido = new Pedido(1001L);

        // Registra os Observers
        pedido.attach(whatsAppService);
        pedido.attach(emailService);

        // Muda o estado do pedido para "EmProdução"
        pedido.setStatus("EmProdução");

        System.out.println("-----------------");

        // Muda o estado novamente para "Enviado"
        pedido.setStatus("Enviado");

        return "Teste do Observer concluído! Verifique o console da aplicação.";
    }

    @GetMapping("/factory")
    public List<Produto> testFactory() {
        // Cria as fábricas
        ProdutoFactory camisaFactory = new CamisaFactory();
        ProdutoFactory canecaFactory = new CanecaFactory();

        // Usa as fábricas para criar os produtos
        Produto produto1 = camisaFactory.criarProduto();
        Produto produto2 = canecaFactory.criarProduto();

        List<Produto> produtosCriados = new ArrayList<>();
        produtosCriados.add(produto1);
        produtosCriados.add(produto2);

        // Retorna a lista, que o Spring converterá para JSON
        return produtosCriados;
    }
}