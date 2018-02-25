/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Víctor de Castro Hurtado
 *
 */
public class ReusablePoolTest {
	
	private ReusablePool poolIns;
	
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
		ReusablePool poolIns = ReusablePool.getInstance();
		assertNotNull(poolIns);
		
		//Se adquiere la instancia de la clase pool
	}
	
	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 * @throws DuplicatedInstanceException 
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException, DuplicatedInstanceException {
		ReusablePool poolIns = ReusablePool.getInstance();
		Reusable re1 = poolIns.acquireReusable();
		assertNotNull(re1);
		poolIns.releaseReusable(re1);
		
		//Se adquiere un objeto del pool
	}

	@Test
	public void testNotEnoughReusables() throws DuplicatedInstanceException, NotFreeInstanceException{
		ReusablePool poolIns = ReusablePool.getInstance();
		Reusable re1 = null, re2 = null, re3 = null;
		
		re1 = poolIns.acquireReusable();
		re2 = poolIns.acquireReusable();
		
		try {
			re3 = poolIns.acquireReusable();
		} catch (NotFreeInstanceException e) {
			
		}
		assertNull(re3);
		poolIns.releaseReusable(re1);
		poolIns.releaseReusable(re2);
		
		//Se intentan adquirir 3 objetos cuando el pool sólo tiene 2
	}
	
	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws NotFreeInstanceException 
	 * @throws DuplicatedInstanceException 
	 */
	
	@Test
	public void testReleaseReusable() throws NotFreeInstanceException, DuplicatedInstanceException {
		ReusablePool poolIns = ReusablePool.getInstance();		
		Reusable re1 = null, re2 = null, re3 = null;

		re1 = poolIns.acquireReusable();
		re2 = poolIns.acquireReusable();
		poolIns.releaseReusable(re1);
		re3 = poolIns.acquireReusable();
		assertNotNull(re3);
		poolIns.releaseReusable(re2);
		poolIns.releaseReusable(re3);
		
		//Se obtienen dos objetos, y como no quedan más libres se libera uno para volver a coger otro.
	}
	
	@Test(expected = DuplicatedInstanceException.class)
	public void testNotReusablesToRelease() throws DuplicatedInstanceException, NotFreeInstanceException {
		ReusablePool poolIns = ReusablePool.getInstance();
		Reusable re1 = null;
		re1 = poolIns.acquireReusable();
		poolIns.releaseReusable(re1);
		poolIns.releaseReusable(re1);
		
		//Se intenta liberar un objeto cuando no hay ninguno en uso
	}


}
