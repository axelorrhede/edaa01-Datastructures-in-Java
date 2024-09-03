package textproc;

import java.util.Comparator;
import java.util.List;

import javax.swing.AbstractListModel;

public class SortedListModel<E> extends AbstractListModel<E> {
	private List<E> list;
	
	public SortedListModel(List<E> list) {
        this.list = list;
    }
	
	public void sort(Comparator<E> comp) {
		list.sort(comp);
		fireContentsChanged(this, 0, list.size()); //Hjälp
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public E getElementAt(int index) {
		return list.get(index);
	}
	
	
}




/*
 * F.2   Metoden som används för att skapa ett map.entry set från en map heter Map.entrySet
 * 
 * F.3  Lambdauttrycket blir: list.sort((e1, e2) -> e1.getValue() - e2.getValue() ); då båda är integers
 * 
 * F.4.1 actionListener i abstracta klassen button
 *  2 getText() returnerar texten i rutan
 *  3 add() använder man för att lägga till ett objekt i sin panel
 *  4. CreateSelectionInterval
 */