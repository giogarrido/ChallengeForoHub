package challenge.foro.ChallengeForoHub.dominio.topico;


public record DatosDetalleTopico(Long id, String titulo, String mensaje, Long autorId, Long cursoId) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
