package com.api.backfotos.controllers;

import com.api.backfotos.dtos.UsuarioDto;
import com.api.backfotos.models.UsuarioModel;
import com.api.backfotos.repositories.UsuarioRepository;
import com.api.backfotos.services.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
@RequestMapping("/api/v1/site-foto/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        if (usuarioService.existsByCpf(usuarioDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário cadastrado com este cpf!");
        }
        if (usuarioService.existsByEmail(usuarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuário com este e-amil!");
        }

        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }

    @GetMapping
    public ResponseEntity <List<UsuarioModel>> getAllUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

}
