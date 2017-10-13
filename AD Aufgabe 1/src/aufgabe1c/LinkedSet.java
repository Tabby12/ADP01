package aufgabe1c;

import aufgabe1a.Elem;
import aufgabe1a.Pos;
import aufgabe1a.Set;

public class LinkedSet implements Set
{
	private ElementKnoten _startKnoten;
	private ElementKnoten _endKnoten;
	private int _anzElemente = 0;

	public LinkedSet()
	{
		Elem<String> start = new Elem<String>(null);

		Elem<String> ende = new Elem<String>(null);

		_startKnoten = new ElementKnoten(start);
		_endKnoten = new ElementKnoten(ende);
		_startKnoten.setNext(_endKnoten);
	}

	@Override
	public Pos add(Elem<?> elem)
	{
		int index = -1;
		if (!contains(elem))
		{
			ElementKnoten eingefuegt = new ElementKnoten(elem);
			ElementKnoten knotenVor = _startKnoten;

			for (index = 0; index < _anzElemente; index++)
			{
				knotenVor = knotenVor.getNext();
			}

			eingefuegt.setNext(knotenVor.getNext());
			knotenVor.setNext(eingefuegt);
			_anzElemente++;
			return new Pos(elem, this, true);
		}

		return new Pos(elem, this, false);
		// index;
	}

	/**
	 * @param pos
	 *            1 ist die position des ersten elements 2 die des 2. usw.
	 */
	@Override
	public void delete(Pos pos)
	{
		if(pos.isValid())
		{
			ElementKnoten knotenVor = _startKnoten;
			int intPos = sucheElemPos(pos.getElememt());
			for (int i = 1; i < intPos; i++)
			{
				knotenVor = knotenVor.getNext();
			}
			knotenVor.setNext(knotenVor.getNext().getNext());
			_anzElemente--;
		}

	}

	@Override
	public void deleteKey(int key)
	{
		if(_anzElemente > 0)
		{
			ElementKnoten knotenVor = _startKnoten.getNext();
			int index = 0;
			while (index < _anzElemente && knotenVor.getElem().getKey() != key)
			{
				knotenVor = knotenVor.getNext();
				index++;
			}
			if(index < _anzElemente)
			{
				knotenVor.setNext(knotenVor.getNext().getNext());
			}
			
		}
	
	}

	@Override
	public Pos find(int key)
	{
		ElementKnoten knoten = _startKnoten;
		for (int index = 0; index < _anzElemente; index++)
		{
			knoten = knoten.getNext();
			if (knoten.getElem().getKey() == key)
			{
				return null;// index
			}
		}
		return null;// -1
	}

	@Override
	public Elem<?> retrieve(Pos pos)
	{
		return pos.getElememt();
	}

	@Override
	public void showall()
	{
		ElementKnoten knoten = _startKnoten;
		for (int i = 0; i < _anzElemente; i++)
		{
			knoten = knoten.getNext();
			System.out.println(knoten.getElem().toString());
		}
	}

	@Override
	public int size()
	{
		return _anzElemente;
	}

	@Override
	public boolean contains(Elem<?> elem)
	{
		ElementKnoten knoten = _startKnoten;
		for (int i = 0; i < _anzElemente; i++)
		{
			knoten = knoten.getNext();
			if (knoten.getElem().getKey() == elem.getKey())
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Set unify(Set s)
	{
		if (_anzElemente > 0)
		{
			ElementKnoten knoten = _startKnoten.getNext();
			
			for (int i = 0; i < size(); i++)
			{
				s.add(knoten.getElem());
				knoten = knoten.getNext();
			}
			
		}
		return s;

	}

//	/**
//	 * gueltige Position alles zwischen 1-anzElemente
//	 * 
//	 * @param pos
//	 * @return
//	 */
//	private boolean isValidPos(int pos)
//	{
//		return 0 < pos && pos <= _anzElemente;
//	}

	private int sucheElemPos(Elem<?> elem)
	{
		ElementKnoten knotenVor = _startKnoten.getNext();
		for (int i = 1; i <= _anzElemente; i++)
		{
			if (knotenVor.getElem().getKey() == elem.getKey())
			{
				return i;
			}
			knotenVor = knotenVor.getNext();
		}
		return -1;
	}

}
