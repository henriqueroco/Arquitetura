package com.exemplo.sistema.api;

import com.exemplo.sistema.model.Cliente;
import com.exemplo.sistema.repository.ClienteRepository;
import com.exemplo.sistema.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> listar(@RequestParam(required = false) String filtro) {
        return filtro == null ? clienteRepository.findAll() : clienteRepository.findByNomeContainingIgnoreCase(filtro);
    }

    @GetMapping("/token")
    public String gerarToken(@RequestParam String user) {
        return tokenService.gerarToken(user);
    }
}
