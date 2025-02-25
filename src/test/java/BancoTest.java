import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {
    private Banco banco;

    @BeforeEach
    public void crearDatosPrueba() {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        LinkedList<BilleteraVirtual> billeteras = new LinkedList<>();
        usuarios.add(new Usuario("Jose", "Armenia", "4187", "Jose@gmail.com", "123"));
        usuarios.add(new Usuario("Maria", "Calarca", "2304", "Maria@gmail.com", "234"));
        usuarios.add(new Usuario("Luis", "LaTebaida", "1090", "Luis@gmail.com", "345"));

        banco = new Banco("Bancolombia", usuarios, billeteras);
        banco.setUsuarios(usuarios);
    }
    @Test
    public void crearUsuarioTest(){

        Usuario usuario4 = new Usuario(
                "Juan","Caicedonia","1092", "Juan@gmail.com", "456");

        assertDoesNotThrow( () -> {
            banco.registrarUsuario(usuario4);
        } );

        Usuario usuarioAgregado = banco.validarUsuario("1092");
        assertNotNull(usuarioAgregado);

    }

    @Test
    public void validarUsuarioTest(){
        Usuario usuario = banco.validarUsuario("4187");

        assertNotNull(usuario);
        assertEquals("Jose", usuario.getNombre());
        assertEquals("Armenia", usuario.getDireccion());
        assertEquals("Jose@gmail.com", usuario.getCorreo());
    }

    @Test
    public void actualizarTest(){
        Usuario usuario = new Usuario(
                "Felipe", "Cali", "4187", "Felipe@gmail.com", "678");

        assertDoesNotThrow( () -> {banco.actualizarDatos(usuario);} );

        Usuario usuarioActualizado= banco.validarUsuario("4187");

        assertNotNull(usuarioActualizado);
        assertEquals("Felipe", usuarioActualizado.getNombre());
        assertEquals("Cali",  usuarioActualizado.getDireccion());
        assertEquals("Felipe@gmail.com", usuarioActualizado.getCorreo());
    }

    @Test
    public void eliminarUsuarioTest(){
        assertDoesNotThrow( () -> {banco.eliminarUsuario("4187");} );

        Usuario usuario = banco.validarUsuario("4187");
        assertNull(usuario);
    }

    @Test
    public void crearBilleteraTest(){

        Usuario usuario = new Usuario("Gabriel", "Pereira", "1080", "Gabriel@gmail.com", "789");
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("5", 100000.00f,usuario);

        assertDoesNotThrow( () -> {
            banco.crearBilleteraVirtual(billeteraVirtual);
        } );

        BilleteraVirtual billeteraAgregada = banco.validarBilletera("5");
        assertNotNull(billeteraAgregada);

    }

}
