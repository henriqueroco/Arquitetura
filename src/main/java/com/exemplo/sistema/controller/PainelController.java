package com.exemplo.sistema.controller;

import com.exemplo.sistema.model.Cliente;
import com.exemplo.sistema.repository.ClienteRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class PainelController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/painel")
    public String listarClientes(@RequestParam(required = false) String filtro, Model model) {
        List<Cliente> clientes = filtro == null || filtro.isEmpty()
                ? clienteRepository.findAll()
                : clienteRepository.findByNomeContainingIgnoreCase(filtro);
        model.addAttribute("clientes", clientes);
        return "painel";
    }

    @GetMapping("/exportar")
    public void exportarCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=clientes.csv");
        PrintWriter writer = response.getWriter();
        writer.println("Nome,Endereco,Contato");

        for (Cliente cliente : clienteRepository.findAll()) {
            writer.printf("%s,%s,%s%n", cliente.getNome(), cliente.getEndereco(), cliente.getContato());
        }

        writer.flush();
        writer.close();
    }
}