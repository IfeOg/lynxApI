package com.example.lynxAPI.service;

import com.example.lynxAPI.model.Client;

import java.io.Writer;
import java.util.List;

public interface ClientService {

    Client createClient (Client client);

    Client updateClient (Client client);

    List<Client> getAllClient();

    Client getClientById(long clientId);

    void deleteClient(long id);

    void getAllClientsCSV(Writer writer);

}
