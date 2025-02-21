import java.util.LinkedList;

public class BilleteraVirtual {
    private String numeroAleatorio;
    private float saldo;
    private Usuario usuario;
    public LinkedList<Transaccion> transacciones;

    public BilleteraVirtual(String numeroAleatorio, float saldo, Usuario usuario) {
        this.numeroAleatorio = numeroAleatorio;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(LinkedList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public String getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(String numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "BilleteraVirtual{" +
                "numeroAleatorio=" + numeroAleatorio +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }

    public void recargarBilletera(float ingreso, BilleteraVirtual billetera) {
        if (ingreso <= 0) {
            throw new IllegalArgumentException("El monto de recarga debe ser mayor a 0");
        } else {
            billetera.setSaldo(billetera.getSaldo() + ingreso);
        }
    }



}
