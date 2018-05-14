import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ListOrders implements Iterator{
	private Vector orders;
	private IOrder nextOrder;
	private Enumeration enumOrders;
	
	ListOrders() {
		this.orders = new Vector();
	}
	
	public void add(Object obj) {
		this.orders.add(obj);
		this.enumOrders = this.orders.elements();
	}
	
	public void clear() {
		this.orders.clear();
	}
	
	public boolean hasNext() {
		this.nextOrder = null;
		if (this.enumOrders.hasMoreElements()) {
			this.nextOrder = (IOrder) this.enumOrders.nextElement();
		}
		return (this.nextOrder != null);
	}

	public Object next() {
		if (this.nextOrder == null) {
			throw new NoSuchElementException();
		} else {
			return this.nextOrder;
		}
	}

}
