package com.example.lynxAPI.controller;

import com.example.lynxAPI.model.Client;
import com.example.lynxAPI.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients/{id}")
    public ResponseEntity <Client> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

    @PostMapping("/clients")
    public ResponseEntity < Client > createProduct(@RequestBody Client client) {
        return ResponseEntity.ok().body(this.clientService.createClient(client));
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok().body(clientService.getAllClient());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity < Client > updateClient(@PathVariable long id, @RequestBody Client client) {
        client.setId(id);
        return ResponseEntity.ok().body(this.clientService.updateClient(client));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteClient(@PathVariable long id) {
        this.clientService.deleteClient(id);
        return HttpStatus.OK;
    }

    @GetMapping("/clients/csv")
    public void getAllClientsCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"clients.csv\"");
        clientService.getAllClientsCSV(servletResponse.getWriter());

    }



}
