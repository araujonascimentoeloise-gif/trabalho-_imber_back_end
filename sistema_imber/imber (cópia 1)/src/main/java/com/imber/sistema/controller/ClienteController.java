package com.imber.sistema.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imber.sistema.entity.Participante;
import com.imber.sistema.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    /* =========================================================
       ENDPOINT: CADASTRAR CLIENTE
       ========================================================= */

    @PostMapping
    public Participante cadastrar(@RequestBody Participante cliente) {
        return service.cadastrar(cliente);
    }

    /* =========================================================
       ENDPOINT: LISTAR CLIENTES
       ========================================================= */

    @GetMapping
    public List<Participante> listar() {
        return service.listarTodos();
    }
    /* =========================================================
    ENDPOINT: BUSCAR CLIENTE POR ID
    ========================================================= */

 @GetMapping("/{id}")
 public Participante buscarPorId(@PathVariable Long id) {
     return service.buscarPorId(id);
 }
 /* =========================================================
 ENDPOINT: ATUALIZAR CLIENTE
 ========================================================= */

@PutMapping("/{id}")
public Participante atualizar(@PathVariable Long id, @RequestBody Participante cliente) {
  return service.atualizar(id, cliente);
}

/* =========================================================
ENDPOINT: DELETAR CLIENTE
========================================================= */

@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
 service.deletar(id);
}


}