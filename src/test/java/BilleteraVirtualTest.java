import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class BilleteraVirtualTest {
    private BilleteraVirtual billetera;
    private Usuario usuario;
    private LinkedList<Transaccion> transacciones;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan Perez", "Calle 123", "12345678", "juan@example.com", "password");
        billetera = new BilleteraVirtual("987654321", 1000, usuario);
        transacciones = new LinkedList<>();
        billetera.setTransacciones(transacciones);
    }

    @Test
    void testConsultarSaldo() {
        assertEquals(1000, billetera.getSaldo());
    }

    @Test
    void testConsultarTransaccionesPeriodo() {
        LocalDate fecha = LocalDate.now();
        Transaccion t1 = new Transaccion("T1", billetera, billetera, LocalDateTime.now(), 200, CategoriaTransaccion.INGRESOS);
        Transaccion t2 = new Transaccion("T2", billetera, billetera, LocalDateTime.now().minusDays(1), 300, CategoriaTransaccion.GASOLINA);

        transacciones.add(t1);
        transacciones.add(t2);

        LinkedList<Transaccion> resultado = billetera.consultarTransaccionesPeriodo(fecha);
        assertEquals(1, resultado.size());
        assertEquals("T1", resultado.getFirst().getId());
    }

    @Test
    void testCalcularPeriodo() {
        LocalDate fechaInicio = LocalDate.now().minusDays(5);
        LocalDate fechaFin = LocalDate.now();

        Transaccion t1 = new Transaccion("T1", billetera, billetera, LocalDateTime.now().minusDays(3), 100, CategoriaTransaccion.VIAJES);
        Transaccion t2 = new Transaccion("T2", billetera, billetera, LocalDateTime.now().minusDays(6), 150, CategoriaTransaccion.FACTURAS);

        transacciones.add(t1);
        transacciones.add(t2);

        LinkedList<Transaccion> resultado = billetera.calcularPeriodo(fechaInicio, fechaFin);
        assertEquals(1, resultado.size());
        assertEquals("T1", resultado.getFirst().getId());
    }

    @Test
    void testCalcularPorcentajeGastosIngresos() {
        LocalDate fecha = LocalDate.now();
        Transaccion ingreso = new Transaccion("T1", billetera, billetera, LocalDateTime.now(), 500, CategoriaTransaccion.INGRESOS);
        Transaccion gasto = new Transaccion("T2", billetera, billetera, LocalDateTime.now(), 500, CategoriaTransaccion.GASOLINA);

        transacciones.add(ingreso);
        transacciones.add(gasto);

        String resultado = billetera.calcularPorcentajeGastosIngresos(fecha);
        assertFalse(resultado.contains("Ingresos: 50.0%"));
        assertFalse(resultado.contains("Gastos: 50.0%"));
    }

}
