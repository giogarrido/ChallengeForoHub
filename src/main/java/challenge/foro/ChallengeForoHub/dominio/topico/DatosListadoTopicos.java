package challenge.foro.ChallengeForoHub.dominio.topico;

//Los datos de los tópicos (título, mensaje, fecha de creación, estado, autor y curso)


import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long Id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String autor,
        String curso

) {
    public DatosListadoTopicos (Topico topico){
        this (
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
