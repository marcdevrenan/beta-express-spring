package br.edu.infnet.domain.service;

import br.edu.infnet.betaexpressspringweb.client.AddressClient;
import br.edu.infnet.domain.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressClient addressClient;

    public Address getCep(String cep) {

        return addressClient.getCep(cep);
    }
}
