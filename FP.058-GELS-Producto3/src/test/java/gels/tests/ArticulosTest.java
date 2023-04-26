//Paquetes
package gels.tests;

//Imports
import gels.modelo.Articulos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gels
 */
public class ArticulosTest {

    public ArticulosTest() {
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
/*
    *En el primer test, se crea una instancia de Articulos con los valores de prueba 
    *y se obtiene el resultado esperado de getidArticulos() que es 1.
*/
    @Test
    public void testGetidArticulos() {
        System.out.println("getidArticulos");
        Articulos instance = new Articulos(1, "Articulo 1", 10.0f, 2.0f,3);
        int expResult = 1;
        int result = instance.getidArticulos();
        assertEquals(expResult, result);
    }

/*
    *En el segundo test, se crea una instancia de Articulos con los valores de prueba, 
    *se llama a setidArticulos() con un nuevo valor de 1 
    *y se obtiene el resultado esperado de getidArticulos() que es 1.
    */
    @Test
    public void testSetidArticulos() {
        System.out.println("setidArticulos");
        int idArticulo = 1;
        Articulos instance = new Articulos(1, "Articulo 1", 10.0f, 2.0f,3);
        instance.setidArticulos(idArticulo);
        int expResult = 1;
        int result = instance.getidArticulos();
        assertEquals(expResult, result);
    }
}