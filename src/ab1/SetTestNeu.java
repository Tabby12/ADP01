package ab1;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;


public abstract class SetTestNeu<T>
{
	private Set<T> _s;
	Element<Integer> _elem;
	
	public abstract Set<T> erzeugeSet();
	
	@Before
	public void setUp()
	{
		_elem = new Element<Integer>(new Integer(2000));
		_s = erzeugeSet();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd()
	{
		_elem = null;
		assertTrue(_s.size() == 0);
		_elem = new Element<Integer>(new Integer(6),new Key());
		_s.add((Element<T>) _elem);
		
		for(int i = 0; i < 5; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
		}
		assertTrue(_s.size() == 6);
		//selbes Element nochmal adden
		_s.add((Element<T>) _elem);

		assertTrue(_s.size() == 6);
		
		for(int i = 5; i < 50; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
		}
		
		assertTrue(_s.size() == 51);
		//sucht nach bereits enthaltenem key returnte Pos sollte valid sein
		assertTrue(_s.find(_elem.getKey()).isValid());
		
		assertEquals(_elem, _s.retrieve(new Pos<T>(true, (Element<T>) _elem, 50)));
		
		for(int i = 50; i < 1000; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
		}
		assertTrue(_s.size() == 1001);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteKey()
	{
		
		_elem = null;
		Key[] keys = new Key[200];
		for(int i = 0; i < 100; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
			keys[i] = _elem.getKey();
		}
		
		assertTrue(_s.size() == 100);
		_s.delete(_elem.getKey());
		assertTrue(_s.size() == 99);
		
//		s.delete(elem.getKey());
		assertTrue(_s.size() == 99);
		
//		assertFalse(s.find(elem.getKey()).isValid());
		
		for(int i = 0; i < 50; i++)
		{
			_s.delete(keys[i]);
		}
		
		assertTrue(_s.size() == 49);
		
		for(int i = 0; i < 200; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
			keys[i] = _elem.getKey();
		}
		assertTrue(_s.size() == 249);
		//40 elemente in der mitte löschen
		for(int i = 80; i < 120; i++)
		{
			_s.delete(keys[i]);
		}
		assertTrue(_s.size() == 209);
		
//		s.find(keys[100])
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeletePos()
	{
		_elem = new Element<Integer>(new Integer(0));
		Pos<T> pos = _s.add((Element<T>) _elem);
		assertTrue(_s.size() == 1);
		
		_s.delete(pos);
		
		assertTrue(_s.size() == 0);
		
		Pos<T>[] positionen = new Pos[100];
		for(int i = 0; i < 100; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			positionen[i] = _s.add((Element<T>) _elem);
		}
		
		assertTrue(_s.size() == 100);
		
		for(int i = 40; i < 60; i++)
		{
			_s.delete(positionen[i]);
		}
		
		assertTrue(_s.size() == 80);
		
		
				
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFind()
	{
		_elem = new Element<Integer>(new Integer(0));
		Element<T> elem2 = (Element<T>) new Element<Integer>(new Integer(1));
		_s.add((Element<T>) _elem);
		Pos<T> pos = _s.find(_elem.getKey());
		assertTrue(pos.getIndex() == 1);
		assertEquals(_elem, pos.getReference());
		assertTrue(pos.isValid());
		
		pos = _s.find(elem2.getKey());
		
		assertFalse(pos.isValid()); //NullPointerException
		assertTrue(pos.getIndex() == -1);
		assertTrue(pos.getReference() == null);
		
		
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUnify()
	{
		Set<T> t = erzeugeSet();
		_elem = null;
		
		Set<T> unifiedSet = _s.unify(t);
		
		assertTrue(unifiedSet.size() == 0);
		unifiedSet.add((Element<T>) new Element<Integer>(new Integer(1000)));
		unifiedSet = unifiedSet.unify(t);
		assertTrue(unifiedSet.size() == 1);
		
		
		
		
		for(int i = 0; i < 5; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			_s.add((Element<T>) _elem);
		}

		t.add((Element<T>) _elem);
		
		for(int i = 5; i < 10; i++)
		{
			_elem = new Element<Integer>(new Integer(i));
			t.add((Element<T>) _elem);
		}
		
		// s: 5 Elemente, t: 6 Elemente, beide haben eines gemeinsam
		unifiedSet = _s.unify(t);
		assertTrue(unifiedSet.size() == 10);
		assertEquals(_elem, unifiedSet.find(_elem.getKey()).getReference());


	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRetrieve()
	{
		Pos<T> pos = _s.add((Element<T>) _elem);
		assertEquals(_elem, _s.retrieve(pos));
		assertTrue(pos.getIndex() == 1);
		assertTrue(pos.isValid());
		_s.delete(_elem.getKey());
		pos = _s.find(_elem.getKey());
		_elem = (Element<Integer>) _s.retrieve(pos);
		assertTrue(_elem == null);
	}
}
