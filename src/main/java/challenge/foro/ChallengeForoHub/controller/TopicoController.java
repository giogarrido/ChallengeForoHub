package challenge.foro.ChallengeForoHub.controller;

import challenge.foro.ChallengeForoHub.dominio.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroTopico registro;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {

        var detalleTopico = registro.registrar(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    @Transactional
    public ResponseEntity <Page<DatosListadoTopicos>> listarTopicos(@PageableDefault (size = 5, sort = "titulo" ) Pageable pageable) {

        return ResponseEntity.ok(topicoRepository.findAll(pageable).map(DatosListadoTopicos::new));
    }


    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosDetalleTopico(topico);

        return ResponseEntity.ok(datosTopico);
    }

}

