package com.api.backfotos.controllers;

import com.api.backfotos.dtos.FotografoDto;
import com.api.backfotos.models.ClienteModel;
import com.api.backfotos.models.FotografoModel;
import com.api.backfotos.services.FotografoService;
import org.apache.coyote.Response;
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
@RequestMapping("/api/v1/site-foto/fotografo")
public class FotografoController {

    final FotografoService fotografoService;

    public FotografoController(FotografoService fotografoService){
        this.fotografoService = fotografoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarfotografo(@RequestBody @Valid FotografoDto fotografoDto){
        if (fotografoService.existsByCpf(fotografoDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário cadastrado com esse cpf!");
        }
        if (fotografoService.existsByEmail(fotografoDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário cadastrado com esse e-mail!");
        }
        var fotografoModel = new FotografoModel();
        BeanUtils.copyProperties(fotografoDto, fotografoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fotografoService.save(fotografoModel));
    }

    @GetMapping
    public ResponseEntity <List<FotografoModel>> getAllFotografos(){
        return ResponseEntity.status(HttpStatus.OK).body(fotografoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFotografoById(@PathVariable(value = "id") @Valid UUID id){
        Optional<FotografoModel> fotografoModelOptional = fotografoService.findById(id);
        if (!fotografoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(fotografoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFotografoById(@PathVariable(value = "id") @Valid UUID id){
        Optional<FotografoModel> fotografoModelOptional = fotografoService.findById(id);
        if (!fotografoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        fotografoService.delete(fotografoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFotografoById(@PathVariable(value = "id") @Valid UUID id, FotografoDto fotografoDto){
        Optional<FotografoModel> fotografoModelOptional = fotografoService.findById(id);
        if (!fotografoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        var fotografoModel = new FotografoModel();
        BeanUtils.copyProperties(fotografoDto, fotografoModel);
        fotografoModel.setId(fotografoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(fotografoService.save(fotografoModel));
    }
}
