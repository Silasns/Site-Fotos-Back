package com.api.backfotos.controllers;

import com.api.backfotos.dtos.ClienteDto;
import com.api.backfotos.models.ClienteModel;
import com.api.backfotos.models.PessoaModel;
import com.api.backfotos.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
@RequestMapping("/api/v1/site-foto/usuario")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody @Valid ClienteDto clienteDto){
        if (clienteService.existsByCpf(clienteDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário cadastrado com este cpf!");
        }
        if (clienteService.existsByEmail(clienteDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário com este e-amil!");
        }

        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity <List<ClienteModel>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Object> getClienteById(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClienteById(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClienteById(@PathVariable(value = "id") UUID id, @RequestBody @Valid ClienteDto clienteDto ){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encotrado");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));

    }

}
