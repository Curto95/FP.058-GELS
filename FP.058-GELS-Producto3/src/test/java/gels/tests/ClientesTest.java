package gels.tests;

import gels.modelo.ClienteEstandar;
import gels.modelo.ClientePremium;
import gels.modelo.Clientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucia.hidalgo
 */
public class ClientesTest {

    public ClientesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //Este test comprueba que se puede realizar el get de email de cliente Estandar
    @Test
    public void testGetEmailEstandar() {
        Clientes c = new ClienteEstandar("Gels2", "Calle de los palotes2", "1234", "gels@gels.gels",ClienteEstandar.TipoCliente.ESTANDAR);
        String expResult = "gels@gels.gels";
        String result = c.getEmail();
        assertEquals(expResult, result);
    }
    
    //Este test comprueba que se puede realizar el get de email de cliente premium
    public void testGetEmailPremium() {
        Clientes c = new ClientePremium("Gels2", "Calle de los palotes2", "1234", "gels@gels.gels",ClienteEstandar.TipoCliente.PREMIUM);
        String expResult = "gels@gels.gels";
        String result = c.getEmail();
        assertEquals(expResult, result);
    }
}
