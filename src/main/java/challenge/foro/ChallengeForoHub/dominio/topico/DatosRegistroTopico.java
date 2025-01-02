package challenge.foro.ChallengeForoHub.dominio.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank(message = "El título no puede estar vacío") String titulo,
        @NotBlank(message = "El mensaje no puede estar vacío") String mensaje,
        @NotNull(message = "El ID del autor es obligatorio") Long autorId,
        @NotNull(message = "El ID del curso es obligatorio") Long cursoId
) {}
