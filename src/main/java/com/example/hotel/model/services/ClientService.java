package com.example.hotel.model.services;


import com.example.hotel.model.entities.ClientsEntity;
import com.example.hotel.model.entities.HotelsEntity;
import com.example.hotel.model.repositories.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<ClientsEntity> getAllClients() {


        return (List<ClientsEntity>) clientRepository.findAll();

    }

    public Optional<ClientsEntity> getClientById(int id) {

        return clientRepository.findById(id);
    }


    private ClientsEntity setClient(ClientsEntity client,
                                    String nomCompletClient,
                                    String telephoneClient,
                                    String emailClient,
                                    String adresseClient) {


        client.setNomCompletClient(nomCompletClient);
        client.setTelephoneClient(telephoneClient);
        client.setEmailClient(emailClient);
        client.setAdresseClient(adresseClient);

        return client;

    }


    @Transactional
    public ClientsEntity addClient(
                                   String nomCompletClient,
                                   String telephoneClient,
                                   String emailClient,
                                   String adresseClient) {

        ClientsEntity client = new ClientsEntity();
        return clientRepository.save(setClient(client,
                nomCompletClient,
                telephoneClient,
                emailClient,
                adresseClient));

    }


    @Transactional
    public ClientsEntity updateClientById(int id,
                                          String nomCompletClient,
                                          String telephoneClient,
                                          String emailClient,
                                          String adresseClient) {

        Optional<ClientsEntity> clientOptional = getClientById(id);
        if (clientOptional.isPresent()) {
            return clientRepository.save(setClient(clientOptional.get(), nomCompletClient, telephoneClient, emailClient, adresseClient)) ;

        } else {
            throw new ObjectNotFoundException(id, "Client non trouvé");
        }
    }

    @Transactional
    public void deleteClientById(int id) {

        Optional<ClientsEntity> clientOptional = getClientById(id);
        if (clientOptional.isPresent()) {clientRepository.delete(clientOptional.get()) ;

        } else {
            throw new ObjectNotFoundException(id, "Client non trouvé");

            }
    }

}