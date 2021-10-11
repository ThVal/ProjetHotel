package com.example.hotel.api;


import com.example.hotel.model.entities.ClientsEntity;
import com.example.hotel.model.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")


public class ClientControllerApi {

    private ClientService clientService;

    public ClientControllerApi(ClientService clientService) {

        this.clientService = clientService;
    }

    @GetMapping(path ="", produces = "application/json")
    public List<ClientsEntity> getClientListApi () {
        return clientService.getAllClients(); }


    @GetMapping (path = "/{id}", produces = "application/json")
    public ClientsEntity getClientByIdApi(@PathVariable("id") int id) {
        Optional<ClientsEntity> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }

   // int id,
   // String nomCompletClient,
   // String telephoneClient,
   // String emailClient,
   // String adresseClient)


    @PostMapping( path ="", produces = "application/json")
    public ResponseEntity<ClientsEntity> addClientApi(@RequestBody ClientsEntity clientInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientService.addClient(
                        clientInput.getNomCompletClient(),
                        clientInput.getTelephoneClient(),
                        clientInput.getEmailClient(),
                        clientInput.getAdresseClient()
                )
        );
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ClientsEntity> editClientlApi(@PathVariable("id") int id, @RequestBody ClientsEntity clientInput) {
        Optional<ClientsEntity> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    clientService.updateClientById(id,
                            clientInput.getNomCompletClient(),
                            clientInput.getTelephoneClient(),
                            clientInput.getEmailClient(),
                            clientInput.getAdresseClient()));


        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client is not found");
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteClientApi(@PathVariable("id") int id) {
        Optional<ClientsEntity> clientOptional = clientService.getClientById(id);
        if (clientOptional.isPresent()) {
            clientService.deleteClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body("client" + id + "effacé");

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The hotel is not found");
        }
    }


}
