package br.will.msUsuario.infrastructure.controller;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.msUsuario.infrastructure.dto.UsuarioData;
import br.will.msUsuario.infrastructure.dto.response.BaseResponse;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;
import br.will.msUsuario.infrastructure.mapper.UsuarioMapper;
import br.will.msUsuario.usecase.DeletarUsuarioUseCase;
import br.will.msUsuario.usecase.SalvarUsuarioUseCase;
import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private UsuarioMapper usuarioMapper;
   private SalvarUsuarioUseCase salvarUsuarioUseCase;
   private DeletarUsuarioUseCase deletarUsuarioUseCase;

   private final KafkaProducer KafkaProducer;


    public UsuarioController(UsuarioMapper usuarioMapper, SalvarUsuarioUseCase salvarUsuarioUseCase, DeletarUsuarioUseCase deletarUsuarioUseCase, KafkaProducer kafkaProducer) {
    this.usuarioMapper = usuarioMapper;
    this.salvarUsuarioUseCase = salvarUsuarioUseCase;
    this.deletarUsuarioUseCase = deletarUsuarioUseCase;
    this.kafkaProducer = kafkaProducer;
}
    

    @PostMapping("/CriarUsuario")
   public BaseResponse<String> criarUsuario(@RequestBody UsuarioData data){
    System.out.println("inicio da criacao do usuario, usercontroller");
    salvarUsuarioUseCase.criarUsuario(usuarioMapper.toUser(data), data.nome(),data.email(),data.senha(), false);
    System.out.println("usuario foi criado, usercontroller");
    return BaseResponse.<String>builder().success(true).message("usuario creado").build();

    kafkaProducer.sendMessage("meu topico", message);
     
   }

   @DeleteMapping("/{id}")
   @Transactional
   public UsuarioEntity deleteById(@PathVariable Long id){
    System.out.println("usuario foi deletado, usercontroller");
    deletarUsuarioUseCase.deletarUsuario(null, id);
    return null;

    kafkaProducer.sendMessage("meu topico", message);
    
   }




}
