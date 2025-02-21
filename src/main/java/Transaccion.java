import java.time.LocalDate;

public class Transaccion {
    String id;
    private BilleteraVirtual destino;
    private BilleteraVirtual origen;
    private LocalDate fecha;
    private CategoriaTransaccion categoriaTransaccion;

    public Transaccion(String id,BilleteraVirtual destino, BilleteraVirtual origen, LocalDate fecha, CategoriaTransaccion categoriaTransaccion) {
        this.id = id;
        this.destino = destino;
        this.origen = origen;
        this.fecha = fecha;
        this.categoriaTransaccion = categoriaTransaccion;
    }

    public BilleteraVirtual getDestino() {
        return destino;
    }

    public void setDestino(BilleteraVirtual destino) {
        this.destino = destino;
    }

    public BilleteraVirtual getUsuarioEmisor() {
        return origen;
    }

    public void setOrigen(BilleteraVirtual origen) {this.origen = origen;}

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
        return "Transaccion{" + "destino=" + destino + ", origen=" + origen + ", fecha=" + fecha + ", categoriaTransaccion=" + categoriaTransaccion + '}';
    }
}