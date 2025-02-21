import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;

public class Banco {
    public String nombre;
    public LinkedList<Usuario> usuarios;
    public LinkedList<BilleteraVirtual> billeterasVirtuales;

    public Banco(String nombre, LinkedList<Usuario> usuarios, LinkedList<BilleteraVirtual> billeterasVirtuales) {
        this.nombre = nombre;
        this.usuarios = usuarios;
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

    public String generarNumeroAleatorio(int longitud){
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10);
            numero.append(digito);
        }
        return numero.toString();
    }

    public BilleteraVirtual validarBilletera(String numeroAleatorio){
        return billeterasVirtuales
                .stream()
                .filter(e -> e.getNumeroAleatorio().equals(numeroAleatorio))
                .findFirst()
                .orElse(null);
    }

    public BilleteraVirtual bucarBilletera(String cedula, String contrasenia) {
        return billeterasVirtuales
                .stream()
                .filter(e -> e.getUsuario().getCedula().equals(cedula)&& e.getUsuario().getContrasenia().equals(contrasenia))
                .findFirst()
                .orElse(null);
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

    public LinkedList<BilleteraVirtual> getBilleterasVirtuales() {
        return billeterasVirtuales;
    }

    public void setBilleterasVirtuales(LinkedList<BilleteraVirtual> billeterasVirtuales) {
        this.billeterasVirtuales = billeterasVirtuales;
    }

    @Override
    public String toString() {
        return "Banco{" + "nombre='" + nombre + '\'' + ", usuarios=" + usuarios + ", billeterasVirtuales=" + billeterasVirtuales + '}';
    }
}
