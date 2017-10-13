package aufgabe1b;

import aufgabe1a.Elem;
import aufgabe1a.Pos;
import aufgabe1a.Set;

public class ArraySet2 implements Set
{
	private int _endIndex;

	private int _arrGroesse;

	private int _anzElemente;

	private ElemContainer[] _arr;
	
	
	public ArraySet2()
	{
		_arrGroesse = 10;
		_endIndex = 1;
		_arr = new ElemContainer[_arrGroesse];

	}

	@Override
	public Pos add(Elem<?> elem)
	{

		if (!contains(elem))
		{
			if(_endIndex == _arrGroesse)
			{
				ElemContainer[] neuArr = new ElemContainer[_arrGroesse * 2];
				neuArr[0] = _arr[0];
				int index = neuArr[0].getNext();
				for(int i = 1; i <= _anzElemente; i++)
				{
					neuArr[index] = _arr[index];
					index = neuArr[index].getNext();
				}
				_arr = neuArr;
				_arrGroesse = _arrGroesse * 2;
			}
			ElemContainer elemCont = new ElemContainer(elem);

			elemCont.setNext(sucheNext(_endIndex));
			elemCont.setPrevious(suchePrevious(_endIndex));
			_arr[_endIndex] = elemCont;
			_arr[suchePrevious(_endIndex)].setNext(_endIndex);
			_arr[sucheNext(_endIndex)].setPrevious(_endIndex);
			_endIndex++;
			_anzElemente++;
			return new Pos(elem, this, true);
		}
		else
		{
			return new Pos(elem, this, false);
		}
		
	}

	private int suchePrevious(int pos)
	{
		pos--;
		while (pos != _endIndex && _arr[pos] == null)
		{
			pos = Math.abs((pos - 1) % _arrGroesse);
		}
		return pos;

	}
	
	private int sucheNext(int pos)
	{
		pos++;
		while (pos != _endIndex && _arr[pos] == null)
		{
			pos = (pos + 1) % _arrGroesse;
		}
		
		return pos;
		

	}

	@Override
	public void delete(Pos pos)
	{
		deleteKey(pos.getElememt().getKey());
	}

	private boolean isValidPos(int pos)
	{
		return 0 < pos && pos <= _endIndex && _arr[pos] != null;
	}

	@Override
	public void deleteKey(int key)
	{
		int index = 1;
		while(_arr[index] == null && index < _arrGroesse)
		{
			index++;
		}
		if(isValidPos(index))
		{
			for(int i = 0; i < _anzElemente; i++)
			{
				if(_arr[index].getElem().getKey() == key)
				{
					int previous = _arr[index].getPrevious();
					int next = _arr[index].getNext();

					_arr[previous].setNext(next);
					_arr[next].setPrevious(previous);
					_arr[index] = null;
					_anzElemente--;
					index = next;
				}
				else
				{
					index = _arr[index].getNext();
				}
			}
		}
	}

	@Override
	public Pos find(int key)
	{
		Elem<String> elem = new Elem<String>("x");
		elem.setKey(key);
		_arr[0] = new ElemContainer(elem);
		_arr[sucheNext(0)].setPrevious(0);
		int index = suchePrevious(_endIndex);
		
		while(_arr[index].getElem().getKey() != key)
		{
			index = _arr[index].getPrevious();
		}
		return new Pos(_arr[index].getElem(), this, isValidPos(index));
	}

	@Override
	public Elem<?> retrieve(Pos pos)
	{
		return pos.getElememt();
	}

	@Override
	public void showall()
	{
		for(int i = 0; i < _arrGroesse; i++)
		{
			String out;
			if(_arr[i] == null)
			{
				out = i + ": null";
			}
			else
			{
				out = i + ": " + _arr[i].toString();
			}
			System.out.println(out);
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
		int index = sucheNext(0);
		for(int i = 0; i < _anzElemente; i++)
		{
			if(_arr[index].getElem().getKey() == elem.getKey())
			{
				return true;
			}
			index = _arr[index].getNext();
		}
		return false;
	}

	@Override
	public Set unify(Set s)
	{
		if(s == null)
		{
			throw new NullPointerException();
		}
		int index = suchePrevious(_endIndex);
		
		for(int i = 0; i < size(); i++)
		{
			s.add(_arr[index].getElem());
		}
		return s;
	}

}