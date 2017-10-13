package aufgabe1c;

import aufgabe1a.Elem;
import aufgabe1a.Pos;
import aufgabe1a.Set;

public class StartAufgabe1c
{
	public static void main(String[] args)
	{
		LinkedSet linkedSet = new LinkedSet();
		LinkedSet linkedSet2 = new LinkedSet();
		
		Elem<String> elemString21 = new Elem<String>("Ömer");
		Elem<String> elemString22= new Elem<String>("Paul");
		Elem<String> elemString23 = new Elem<String>("Vado");
		Elem<Integer> elemInt = new Elem<Integer>(Integer.valueOf(123));
		Elem<String> elemString = new Elem<String>("TK");
		Elem<String> elemString2 = new Elem<String>("AH");
		
		
		linkedSet.add(elemString);
		linkedSet.add(elemInt);
		linkedSet.add(elemString2);
		
		linkedSet2.add(elemString2);
		linkedSet2.add(elemString21);
		linkedSet2.add(elemString22);
		linkedSet2.add(elemString23);
		
		linkedSet.showall();
		System.out.println();
		linkedSet2.showall();
		System.out.println();
		Set s = linkedSet.unify(linkedSet2);
		s.showall();
		
		linkedSet.deleteKey(elemInt.getKey());
		linkedSet.delete(new Pos(elemInt, linkedSet, true)); // lösche 123
		System.out.println();
		linkedSet.showall();
		System.out.println();
		linkedSet.showall();
	}
}
