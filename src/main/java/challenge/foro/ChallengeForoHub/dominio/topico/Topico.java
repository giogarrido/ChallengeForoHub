package challenge.foro.ChallengeForoHub.dominio.topico;

import challenge.foro.ChallengeForoHub.dominio.curso.Curso;
import challenge.foro.ChallengeForoHub.dominio.respuesta.Respuesta;
import challenge.foro.ChallengeForoHub.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

//    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
//    private List<Respuesta> respuestas;


//    public Long getId() {
//        return id;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public String getMensaje() {
//        return mensaje;
//    }
//
//    public LocalDateTime getFechaCreacion() {
//        return fechaCreacion;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public Usuario getAutor() {
//        return autor;
//    }
//
//    public Curso getCurso() {
//        return curso;
//    }
//
//    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, Usuario autor, Curso curso) {
//        this.id = id;
//        this.titulo = titulo;
//        this.mensaje = mensaje;
//        this.fechaCreacion = fechaCreacion;
//        this.status = status;
//        this.autor = autor;
//        this.curso = curso;
//    }
}
