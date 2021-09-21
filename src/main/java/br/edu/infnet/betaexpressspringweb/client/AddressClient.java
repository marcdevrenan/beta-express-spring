package br.edu.infnet.betaexpressspringweb.client;

import br.edu.infnet.domain.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "addressClient")
public interface AddressClient {

    @GetMapping(value = "/{cep}/json")
    public Address getCep(@PathVariable String cep);
}
