/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	ReusablePool pool;
	Reusable re1;
	
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
	 */
	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
		pool = ReusablePool.getInstance();
		assert pool == null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		//fail("Not yet implemented");
		testGetInstance();
		try {
			re1 = pool.acquireReusable();
		} catch (NotFreeInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert re1 != null;
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		//fail("Not yet implemented");
		testAcquireReusable();
		try {
			pool.releaseReusable(re1);
		} catch (DuplicatedInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
