package ab1;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public abstract class SetTestNeu<T>
{
	public abstract Set<T> erzeugeSet();
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd()
	{
		Set<T> s = erzeugeSet();
		Element<Integer> elem = null;
		assertTrue(s.size() == 0);
		for(int i = 0; i < 5; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			s.add((Element<T>) elem);
		}
		assertTrue(s.size() == 5);
		//selbes Element nochmal adden
		s.add((Element<T>) elem);

		assertTrue(s.size() == 5);
		
		for(int i = 5; i < 50; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			s.add((Element<T>) elem);
		}
		
		assertTrue(s.size() == 50);
		//sucht nach bereits enthaltenem key returnte Pos sollte valid sein
		assertTrue(s.find(elem.getKey()).isValid());
		
		assertEquals(elem, s.retrieve(new Pos<T>(true, (Element<T>) elem, 50)));
		
		for(int i = 50; i < 1000; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			s.add((Element<T>) elem);
		}
		assertTrue(s.size() == 1000);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteKey()
	{
		Set<T> s = erzeugeSet();
		
		Element<Integer> elem = null;
		Key[] keys = new Key[200];
		for(int i = 0; i < 100; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			s.add((Element<T>) elem);
			keys[i] = elem.getKey();
		}
		
		assertTrue(s.size() == 100);
		s.delete(elem.getKey());
		assertTrue(s.size() == 99);
		
//		s.delete(elem.getKey());
		assertTrue(s.size() == 99);
		
//		assertFalse(s.find(elem.getKey()).isValid());
		
		for(int i = 0; i < 99; i++)
		{
			s.delete(keys[i]);
		}
		
		assertTrue(s.size() == 0);
		
		for(int i = 0; i < 200; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			s.add((Element<T>) elem);
			keys[i] = elem.getKey();
		}
		assertTrue(s.size() == 200);
		//40 elemente in der mitte löschen
		for(int i = 80; i < 120; i++)
		{
			s.delete(keys[i]);
		}
		assertTrue(s.size() == 160);
		
//		s.find(keys[100])
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeletePos()
	{
		Set<T> s = erzeugeSet();
		Element<Integer> elem = null;
		elem = new Element<Integer>(new Integer(0));
		Pos<T> pos = s.add((Element<T>) elem);
		assertTrue(s.size() == 1);
		
		s.delete(pos);
		
		assertTrue(s.size() == 0);
		
		Pos[] positions = new Pos[100];
		for(int i = 0; i < 100; i++)
		{
			elem = new Element<Integer>(new Integer(i));
			positions[i] = s.add((Element<T>) elem);
		}
		
		assertTrue(s.size() == 100);
		
		for(int i = 40; i < 60; i++)
		{
			s.delete(positions[i]);
		}
		
		assertTrue(s.size() == 80);
		
		
				
	}
	
	@Test
	public void testFind()
	{
		
	}
}
