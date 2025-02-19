import java.time.LocalDate;

public class Transaccion {
    private Usuario usuarioDestinatario;
    private Usuario usuarioEmisor;
    private LocalDate fecha;
    private CategoriaTransaccion categoriaTransaccion;

    public Transaccion(Usuario usuarioDestinatario, Usuario usuarioEmisor, LocalDate fecha, CategoriaTransaccion categoriaTransaccion) {
        this.usuarioDestinatario = usuarioDestinatario;
        this.usuarioEmisor = usuarioEmisor;
        this.fecha = fecha;
        this.categoriaTransaccion = categoriaTransaccion;
    }

    public Usuario getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public CategoriaTransaccion getCategoriaTransaccion() {
        return categoriaTransaccion;
    }

    public void setCategoriaTransaccion(CategoriaTransaccion categoriaTransaccion) {
        this.categoriaTransaccion = categoriaTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "usuarioDestinatario=" + usuarioDestinatario + ", usuarioEmisor=" + usuarioEmisor + ", fecha=" + fecha + ", categoriaTransaccion=" + categoriaTransaccion + '}';
    }
}