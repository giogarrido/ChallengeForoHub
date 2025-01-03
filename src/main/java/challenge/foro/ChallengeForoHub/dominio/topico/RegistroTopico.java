package challenge.foro.ChallengeForoHub.dominio.topico;

import challenge.foro.ChallengeForoHub.dominio.ValidacionException;
import challenge.foro.ChallengeForoHub.dominio.curso.CursoRepository;
import challenge.foro.ChallengeForoHub.dominio.topico.validaciones.ValidacionDeTopico;
import challenge.foro.ChallengeForoHub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidacionDeTopico> validaciones;


    public DatosDetalleTopico registrar(DatosRegistroTopico datos) {

        if(!usuarioRepository.existsById(datos.autorId())){
            throw new ValidacionException("No existe un usuario con el id introducido");
        }

        if(!cursoRepository.existsById(datos.cursoId())){
            throw new ValidacionException("No existe un curso con el id introducido");
        }

        //validaciones
        validaciones.forEach(validacion -> validacion.validar(datos));

        var usuario = usuarioRepository.findById(datos.autorId()).get();

        var curso = cursoRepository.findById(datos.cursoId()).get();

        var fecha = java.time.LocalDateTime.now();

        var topico = new Topico (null, datos.titulo().toString(), datos.mensaje().toString(), fecha, "abierto", usuario, curso);

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);
    }

}
