package com.example.lynxAPI.service;

import com.example.lynxAPI.exception.ResourceNotFoundException;
import com.example.lynxAPI.model.Client;
import com.example.lynxAPI.repository.ClientRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.io.Writer;
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
        Optional<Client> clientDb = this.clientRepository.findById(client.getId());

        if (clientDb.isPresent()){
            Client clientUpdate = clientDb.get();
            clientUpdate.setId(client.getId());
            clientUpdate.setEnrollment(client.getEnrollment());
            clientUpdate.setSalary(client.getSalary());
            clientUpdate.setAtRisk(client.isAtRisk());
            clientUpdate.setGambling(client.isGambling());
            clientUpdate.setCrypto(client.isCrypto());
            clientRepository.save(clientUpdate);
            return clientUpdate;
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
        Optional<Client> clientDb = this.clientRepository.findById(id);

        if (clientDb.isPresent()) {
            this.clientRepository.delete(clientDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }


    }

    @Override
    public void getAllClientsCSV(Writer writer) {
        List<Client> clients = clientRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)){
            csvPrinter.printRecord("id", "Enrollment", "Salary", "At Risk", "Crypto", "Gambling");
            for (Client client : clients){
                csvPrinter.printRecord(client.getId(), client.getEnrollment(), client.getSalary(), client.isAtRisk(), client.isCrypto(), client.isGambling());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
