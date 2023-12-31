package ma.adil.adilclientservice.controller;


import ma.adil.adilclientservice.dto.ClientResponse;
import ma.adil.adilclientservice.entities.Client;
import ma.adil.adilclientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> clients(){return clientService.findAll();}
    @GetMapping("/{id}")
    public ClientResponse client(@PathVariable("id") Long id){return clientService.findById(id);}
    @PostMapping
    public void save(@RequestBody Client client){clientService.save(client);}
    @GetMapping("/power/{id}")
    public void power(@PathVariable("id") Long id){clientService.power(id);}
    @DeleteMapping("/trash/{id}")
    public void trash(@PathVariable("id") Long id){clientService.trash(id);}
    @GetMapping("/affect/{id}")
    public void affect(@PathVariable("id") Long id){clientService.affect(id);}
    @PutMapping("/fuel/{id}/{liters}")
    public void fuel(@PathVariable("id") Long id,@PathVariable("liters") Float liters){clientService.fuel(id,liters);}
}
