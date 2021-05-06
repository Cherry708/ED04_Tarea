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
    public void operacionesCuentaTestIngresarValidoTest(){
        pruebaTest.ingresar(10000);
        Assert.assertEquals(10000,pruebaTest.getSaldo(),0.0);
    }

    @Test
    public void operacionesCuentaTestIngresarNegativoTest() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No es posible realizar la operación. La cantidad a ingresar debe ser un número positivo. ");
        pruebaTest.ingresar(-1);
        Assert.assertEquals(0,pruebaTest.getSaldo(),0.0);
    }

    @Test
    public void operacionesCuentaTestRetirarValidoTest(){
        pruebaTest.setSaldo(1);
        pruebaTest.retirar(1);
        Assert.assertEquals(0,pruebaTest.getSaldo(),0.0);
    }

    @Test
    public void operacionesCuentaTestRetirarSaldoInsuficienteTest() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No es posible realizar la operación. El saldo es inferior a la cantidad a retirar. ");
        pruebaTest.setSaldo(0);
        pruebaTest.retirar(1);
        Assert.assertEquals(0,pruebaTest.getSaldo(),0.0);
    }

    @Test
    public void operacionesCuentaTestRetirarSaldoNegativo() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No es posible realizar la operación. La cantidad a retirar debe ser un número positivo. ");
        pruebaTest.setSaldo(0);
        pruebaTest.retirar(-1);
        Assert.assertEquals(0, pruebaTest.getSaldo(),0.0);
    }

}