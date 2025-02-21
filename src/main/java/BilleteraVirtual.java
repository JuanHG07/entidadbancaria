public class BilleteraVirtual {
    private String numeroAleatorio;
    private float saldo;
    private Usuario usuario;

    public BilleteraVirtual(String numeroAleatorio, float saldo, Usuario usuario) {
        this.numeroAleatorio = numeroAleatorio;
        this.saldo = saldo;
        this.usuario = usuario;
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
