package ed.tarea04;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class ControladorCuentaBancariaTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    CuentaBancaria pruebaTest = new CuentaBancaria("Rubén Serrano", "00491500051234567892");

    @Test
    public void operacionesCuentaTestIngresarValidoTest() throws Exception{
        pruebaTest.ingresar(10000);
        Assert.assertEquals(10000,pruebaTest.getSaldo(),0.0);
    }

}