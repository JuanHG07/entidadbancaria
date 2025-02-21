import java.util.LinkedList;

public class BilleteraVirtual {
    private String numeroAleatorio;
    private float saldo;
    private Usuario usuario;
    public LinkedList<Transaccion> transacciones;
    public Banco banco;

    public BilleteraVirtual(String numeroAleatorio, float saldo, Usuario usuario) {
        this.numeroAleatorio = numeroAleatorio;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public void consultarSaldo(String cedula, String contrasenia) throws Exception{
        BilleteraVirtual billeteraVirtual = banco.bucarBilletera(cedula, contrasenia);
        if(billeteraVirtual != null){
            imprimir(billeteraVirtual.toString());
        }
        else{
            throw new Exception("No se encontro la billetera buscada");
        }
    }

    public void imprimir(String mensaje){
        System.out.println(mensaje);
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
}
