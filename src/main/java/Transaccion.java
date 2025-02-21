import java.time.LocalDateTime;

public class Transaccion {
    private String id;
    private BilleteraVirtual origen;
    private BilleteraVirtual destino;
    private LocalDateTime fecha;
    private float monto;
    private CategoriaTransaccion categoria;
    final private float costo = 200;

    public Transaccion(String id, BilleteraVirtual origen, BilleteraVirtual destino, LocalDateTime fecha, float monto, CategoriaTransaccion categoria) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.monto = monto;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BilleteraVirtual getOrigen() {
        return origen;
    }

    public void setOrigen(BilleteraVirtual origen) {
        this.origen = origen;
    }

    public BilleteraVirtual getDestino() {
        return destino;
    }

    public void setDestino(BilleteraVirtual destino) {
        this.destino = destino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public CategoriaTransaccion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTransaccion categoria) {
        this.categoria = categoria;
    }

    public float getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id='" + id + '\'' +
                ", origen=" + origen +
                ", destino=" + destino +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", categoria=" + categoria +
                ", costo=" + costo +
                '}';
    }
}