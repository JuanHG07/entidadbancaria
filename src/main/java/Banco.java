import java.sql.SQLException;
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

    //Metodos de usuarios
    public void registrarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioBuscado = validarUsuario(usuario.getCedula());
        if(usuarioBuscado != null){
            throw new Exception("Ya existe un usuario con la misma cedula");
        }else{
            usuarios.add(usuario);
        }
    }

    public void eliminarUsuario(String cedula) throws Exception {
        Usuario usuarioBuscado = validarUsuario(cedula);
        if(usuarioBuscado==null){
            throw new Exception("No existe un usuario registrado con esta cedula");
        }else{
            usuarios.remove(usuarioBuscado);
        }
    }

    public void actualizarDatos(Usuario nuevoUsuario) throws Exception{
        Usuario usuarioBuscado= validarUsuario(nuevoUsuario.getCedula());

        if(usuarioBuscado!=null){
            usuarioBuscado.setNombre(nuevoUsuario.getNombre());
            usuarioBuscado.setDireccion(nuevoUsuario.getDireccion());
            usuarioBuscado.setCedula(nuevoUsuario.getCedula());
            usuarioBuscado.setCorreo(nuevoUsuario.getCorreo());
            usuarioBuscado.setContrasenia(nuevoUsuario.getContrasenia());

        }else{
            throw new Exception("No existe un usuario con la cedula presentada");
        }
    }

    public Usuario validarUsuario(String cedula){
        return usuarios
                .stream()
                .filter(e -> e.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    //Metodos de billetera
    public void crearBilleteraVirtual(BilleteraVirtual billeteraVirtual) throws Exception {
        BilleteraVirtual billeteraBuscada = validarBilletera(billeteraVirtual.getNumeroAleatorio());
        if(billeteraBuscada != null){
            throw new Exception("Ya existe un usuario con la misma cedula");
        }else{
            billeterasVirtuales.add(billeteraVirtual);
        }
    }

    public BilleteraVirtual validarBilletera(int numeroAleatorio) throws Exception{
        return billeterasVirtuales
                .stream()
                .filter(e -> e.getNumeroAleatorio() == numeroAleatorio)
                .findFirst()
                .orElse(null);
    }


    public void consultarSaldo(String cedula, String contrasenia) throws Exception{
        BilleteraVirtual billeteraVirtual = validarBilletera(Integer.parseInt(contrasenia));
        if(billeteraVirtual != null){
            imprimir(billeteraVirtual.toString());
        }
        else{
            throw new Exception("No se encotro la billetera buscada");

        }
    }

    //Metodos de transaccion(Faltan todos)

    public void imprimir(String mensaje){
        System.out.println(mensaje);
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
