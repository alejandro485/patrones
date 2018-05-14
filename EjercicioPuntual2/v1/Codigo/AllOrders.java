import java.util.Enumeration;
import java.util.Vector;

public class AllOrders implements IOrder {
	private Vector orders;
	
	AllOrders() {
		this.orders = new Vector();
	}
	
	public void add(Object obj) {
		this.orders.add(obj);
	}

	@Override
	public void accept(IOrderVisitor visitor) {
		Enumeration e = this.orders.elements();
		while(e.hasMoreElements()) {
			IOrder order = (IOrder) e.nextElement();
			order.accept(visitor);
		}
	}
	
	public void clear() {
		this.orders.clear();
	}

}
