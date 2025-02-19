import java.util.LinkedList;

public class Banco {
    public String nombre;
    public LinkedList<Usuario> usuarios;
    public LinkedList<Transaccion> transacciones;
    public LinkedList<BilleteraVirtual> billeterasVirtuales;

    public Banco(String nombre, LinkedList<Usuario> usuarios, LinkedList<Transaccion> transacciones, LinkedList<BilleteraVirtual> billeterasVirtuales) {
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.transacciones = transacciones;
        this.billeterasVirtuales = billeterasVirtuales;
    }

    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(LinkedList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public LinkedList<BilleteraVirtual> getBilleterasVirtuales() {
        return billeterasVirtuales;
    }

    public void setBilleterasVirtuales(LinkedList<BilleteraVirtual> billeterasVirtuales) {
        this.billeterasVirtuales = billeterasVirtuales;
    }

    @Override
    public String toString() {
        return "Banco{" + "nombre='" + nombre + '\'' + ", usuarios=" + usuarios + ", transacciones=" + transacciones + ", billeterasVirtuales=" + billeterasVirtuales + '}';
    }
}
