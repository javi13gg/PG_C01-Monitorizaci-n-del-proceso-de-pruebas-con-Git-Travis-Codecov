/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 *
	 * Se comprueba que el método con el patrón Singleton funciona correctamente.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool rp1 = ReusablePool.getInstance();
		ReusablePool rp2 = ReusablePool.getInstance();
		assertEquals("Test para la clase Singleton", rp1, rp2);
	}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 *
	 * Este test comprueba que el método AcquireReusable devuelve una instancia de tipo Reusable.
	 */
	@Test
	public void testAcquireReusable() {
		ReusablePool rp = ReusablePool.getInstance();
		boolean control = true;
		while (control) {
			try {
				assertTrue("Se comprueba que la instancia que se devuelve sea de tipo Reusable.",
						rp.acquireReusable() instanceof Reusable);
			} catch (NotFreeInstanceException e) {
				control = false;
			}
		}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 *
	 * Test para comprobar la función ReleaseReusable
	 */
	@Test
	public void testReleaseReusable() {
		boolean thrown = false;
		ReusablePool rp = ReusablePool.getInstance();
		Reusable r1 = new Reusable();
		Reusable r2 = r1;

		assertTrue("Se comprueba si efectivamente los objetos son el mismo objeto.", r1.equals(r2));

		try {
			rp.releaseReusable(r1);
			rp.releaseReusable(r2);
		} catch (DuplicatedInstanceException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	}

}
