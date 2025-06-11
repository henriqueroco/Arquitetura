package com.exemplo.sistema.service;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {
    public void enviarMensagem(String numero, String texto) {
        System.out.printf("Mensagem enviada para %s: %s%n", numero, texto);
    }
}