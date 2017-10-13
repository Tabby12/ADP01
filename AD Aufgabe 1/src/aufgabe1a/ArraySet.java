package aufgabe1a;

public class ArraySet implements Set
{
	Elem<?>[] _arr;
	private int _endIndex;
	private int _arrGroesse;
	
	public ArraySet() 
	{
		_endIndex = 1;
		_arrGroesse = 10;
		
		_arr = new Elem[_arrGroesse];
	}
	
	@Override
	public Pos add(Elem<?> elem) 
	{
		
		if(istVoll())
		{
			Elem<?>[] neuArr =  new Elem[_arrGroesse * 2];
			for(int i = 0; i < _arrGroesse; i++)
			{
			    neuArr[i] = _arr[i];
			}
			_arr = neuArr;
			_arrGroesse = _arrGroesse * 2;			
		}
		
		if(!contains(elem))
		{
			_arr[_endIndex]= elem;
			_endIndex++; 
			return new Pos(elem, this, true);
		}
		
		return new Pos(elem, this, false);
	}

	@Override
	public void delete(Pos pos) 
	{
		if(pos.isValid())
		{
			deleteKey(pos.getElememt().getKey());
		}
		
	}

	@Override
	public void deleteKey(int key) 
	{
		boolean found = false;
		int index = 1;
		while(!found)
		{
			found = key == _arr[index].getKey();
			index++;
		}
		_arr[index] = null;
		rueckeZusammen(index);
	}
	
	/**
	 * Findet die Position eines Schlüssels in dem Set
	 * @param Schlüssel dessen Position gesucht werden soll.
	 * @return 0 wenn schlüssel nicht gefunden wurde, die position wenn er gefunden
	 */
	@Override
	public Pos find(int key) 
	{
		int index = _endIndex - 1;
		Elem<String> stopElem = new Elem<String>("x");
		stopElem.setKey(key);
		_arr[0] = stopElem;
		
		while(_arr[index].getKey() != key)
		{
			index--;
		}
		return new Pos(_arr[index], this, isValidPos(index));
	}

	@Override
	public Elem<?> retrieve(Pos pos) 
	{
		return pos.getElememt();
	}
		
	private boolean isValidPos(int pos) 
	{
		return  0 < pos && pos < _endIndex; 
	}

	@Override
	public void showall() {
		{
			for(int i = 1; i < _endIndex; i++)
			{
				System.out.println(i + ":" + _arr[i].toString()); 
			}
		}
	}

	@Override
	public int size() {
		
		return _endIndex - 1;
	}

	@Override
	public Set unify(Set s) 
	{
		for(int i = 1; i < size(); i++)
		{
			s.add(_arr[i]);
		}
		
		return s;
	}
	
	private boolean istVoll()
	{
		return _arrGroesse ==_endIndex;
	}
	
	private void rueckeZusammen(int pos)
	{
		for(int i = pos; i < _endIndex; i++)
		{
			_arr[i] = _arr[i+1];			
		}
		_arr[_endIndex] = null;
	}


	public boolean contains(Elem<?> elem) 
	{
		for(int i = 1; i < _endIndex; i++)
		{
			if(_arr[i].getKey() == elem.getKey())
			{
				return true;
			}
		}
		return false;
		
			
	}
	


}
