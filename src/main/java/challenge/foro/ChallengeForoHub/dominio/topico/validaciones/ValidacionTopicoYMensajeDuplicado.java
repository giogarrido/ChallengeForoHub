package challenge.foro.ChallengeForoHub.dominio.topico.validaciones;

import challenge.foro.ChallengeForoHub.dominio.topico.DatosRegistroTopico;
import challenge.foro.ChallengeForoHub.dominio.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import challenge.foro.ChallengeForoHub.dominio.ValidacionException;

@Component
public class ValidacionTopicoYMensajeDuplicado implements ValidacionDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {

        topicoRepository.findFirstByTitulo(datos.titulo())
                .ifPresent(tituloRegistrado -> {
                    if (tituloRegistrado.getMensaje().equalsIgnoreCase(datos.mensaje())) {
                        throw new ValidacionException("No se permiten tópicos duplicados");
                    }
                });


    }
}
