import java.time.LocalDate;
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

    public void recargarBilletera(float ingreso, BilleteraVirtual billetera) {
        if (ingreso <= 0) {
            throw new IllegalArgumentException("El monto de recarga debe ser mayor a 0");
        } else {
            billetera.setSaldo(billetera.getSaldo() + ingreso);
        }
    }


    public LinkedList<Transaccion> consultarTransaccionesPeriodo(LocalDate periodo) {
        LinkedList<Transaccion> transaccionesFiltradasPeriodo = new LinkedList<>();

        for (Transaccion t : transacciones) {
            if (t.getFecha().toLocalDate().equals(periodo)) {
                transaccionesFiltradasPeriodo.add(t);
            }
        }

        return transaccionesFiltradasPeriodo;
    }


    public LinkedList<Transaccion> calcularPeriodo(LocalDate fecha1, LocalDate fecha2) {
        LinkedList<Transaccion> transaccionesCalcularPerioro = new LinkedList<>();

        for (Transaccion t : transacciones) {
            LocalDate fechaTransaccion = t.getFecha().toLocalDate();
            if ((fechaTransaccion.isAfter(fecha1) || fechaTransaccion.equals(fecha1)) &&
                    (fechaTransaccion.isBefore(fecha2) || fechaTransaccion.equals(fecha2))) {
                transaccionesCalcularPerioro.add(t);
            }
        }

        return transaccionesCalcularPerioro;
    }



    public String calcularPorcentajeGastosIngresos(LocalDate periodo) {
        float ingresos = 0;
        float gastos = 0;

        for (Transaccion t : transacciones) {
            if (t.getFecha().toLocalDate().equals(periodo)) {
                if (t.getDestino().equals(this)) {
                    ingresos += t.getMonto();
                } else if (t.getOrigen().equals(this)) { 
                    gastos += t.getMonto();
                }
            }
        }

        float total = ingresos + gastos;
        float porcentajeIngresos = (total > 0) ? (ingresos / total) * 100 : 0;
        float porcentajeGastos = (total > 0) ? (gastos / total) * 100 : 0;

        return "Ingresos: " + porcentajeIngresos + "%, Gastos: " + porcentajeGastos + "%";
    }



}
