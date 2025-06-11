package com.exemplo.sistema.controller;

import com.exemplo.sistema.model.Cliente;
import com.exemplo.sistema.repository.ClienteRepository;
import com.exemplo.sistema.service.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private WhatsAppService whatsAppService;

    @PostMapping
    public String receberMensagem(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        whatsAppService.enviarMensagem(cliente.getContato(), "Olá " + cliente.getNome() + ", recebemos seus dados com sucesso!");
        return "Dados recebidos";
    }
}