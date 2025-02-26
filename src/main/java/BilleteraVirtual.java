import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class BilleteraVirtual {
    private String numeroAleatorio;
    private float saldo;
    private Usuario usuario;
    public LinkedList<Transaccion> transacciones;
    public Banco banco;
    private final int longitud = 5;

    public BilleteraVirtual(String numeroAleatorio, float saldo, Usuario usuario, Banco banco) {
        this.numeroAleatorio = numeroAleatorio;
        this.saldo = saldo;
        this.usuario = usuario;
        this.banco = banco;
        this.transacciones = new LinkedList<>();
    }

    public void consultarSaldo(String cedula, String contrasenia) throws Exception{
        BilleteraVirtual billeteraVirtual = banco.buscarBilletera(cedula, contrasenia);
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

    public Transaccion crearTransaccion(BilleteraVirtual billeteraOrigen,BilleteraVirtual billeteraDestino, float monto, CategoriaTransaccion categoria) throws Exception{
        if (monto < 0) {
            throw new Exception("Monto negativo");
        } else if (billeteraOrigen.getSaldo() < monto) {
            throw new Exception("Saldo insuficiente");

        } else if (billeteraDestino == null) {
            throw new Exception("Billetera nulas");
        } else {
            Transaccion transaccion = new Transaccion(billeteraOrigen.getBanco().generarNumeroAleatorio(longitud), billeteraOrigen, billeteraDestino, LocalDateTime.now(), monto, categoria);
            realizarTransaccion(billeteraOrigen, billeteraDestino, monto);
            billeteraOrigen.getTransacciones().add(transaccion);
            billeteraDestino.getTransacciones().add(transaccion);
            return transaccion;
        }
    }

    public void realizarTransaccion(BilleteraVirtual origen, BilleteraVirtual destino, float monto) {
        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
    }

    public void recargarBilletera(float ingreso) {
        if (ingreso <= 0) {
            throw new IllegalArgumentException("El monto de recarga debe ser mayor a 0");
        }
        this.setSaldo(saldo + ingreso);
    }

    public LinkedList<Transaccion> consultarTransaccionesPeriodo(LocalDate periodo) {
        if (transacciones.isEmpty()) {
            throw new IllegalStateException("No hay transacciones registradas");
        }

        LinkedList<Transaccion> transaccionesFiltradasPeriodo = new LinkedList<>();

        for (Transaccion t : transacciones) {
            if (t.getFecha().toLocalDate().equals(periodo)) {
                transaccionesFiltradasPeriodo.add(t);
            }
        }

        return transaccionesFiltradasPeriodo;
    }

    public LinkedList<Transaccion> calcularPeriodo(LocalDate fecha1, LocalDate fecha2) {
        if (transacciones.isEmpty()) {
            throw new IllegalStateException("No hay transacciones registradas");
        }
        if (fecha1 == null || fecha2 == null || fecha1.isAfter(fecha2)) {
            throw new IllegalArgumentException("Las fechas deben ser válidas y fecha1 debe ser anterior o igual a fecha2");
        }

        LinkedList<Transaccion> transaccionesCalcularPeriodo = new LinkedList<>();

        for (Transaccion t : transacciones) {
            LocalDate fechaTransaccion = t.getFecha().toLocalDate();
            if ((fechaTransaccion.isAfter(fecha1) || fechaTransaccion.equals(fecha1)) &&
                    (fechaTransaccion.isBefore(fecha2) || fechaTransaccion.equals(fecha2))) {
                transaccionesCalcularPeriodo.add(t);
            }
        }

        return transaccionesCalcularPeriodo;
    }

    public String calcularPorcentajeGastosIngresos(LocalDate periodo) {
        if (transacciones.isEmpty()) {
            throw new IllegalStateException("No hay transacciones registradas");
        }

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

        if (ingresos == 0 && gastos == 0) {
            throw new IllegalStateException("No hay ingresos ni gastos en el período seleccionado");
        }

        float total = ingresos + gastos;
        float porcentajeIngresos = (total > 0) ? (ingresos / total) * 100 : 0;
        float porcentajeGastos = (total > 0) ? (gastos / total) * 100 : 0;

        return "Ingresos: " + porcentajeIngresos + "%, Gastos: " + porcentajeGastos + "%";
    }


    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
