package challenge.foro.ChallengeForoHub.controller;

import challenge.foro.ChallengeForoHub.dominio.topico.DatosRegistroTopico;
import challenge.foro.ChallengeForoHub.dominio.topico.RegistroTopico;
import challenge.foro.ChallengeForoHub.dominio.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroTopico registro;


    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        var detalleTopico = registro.registrar(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }
}

