package com.example.lynxAPI.service;

import com.example.lynxAPI.exception.ResourceNotFoundException;
import com.example.lynxAPI.model.Client;
import com.example.lynxAPI.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        Optional<Client> productDb = this.clientRepository.findById(client.getId());

        if (productDb.isPresent()){
            Client productUpdate = productDb.get();
            productUpdate.setId(client.getId());
            //productUpdate.setName(product.getName());
            //productUpdate.setDescription((product.getDescription()));
            clientRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + client.getId());
        }
    }

    @Override
    public List<Client> getAllClient() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client getClientById(long clientId) {
        Optional < Client > clientDb = this.clientRepository.findById(clientId);

        if (clientDb.isPresent()) {
            return clientDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + clientId);
        }
    }

    @Override
    public void deleteClient(long id) {

    }
}
