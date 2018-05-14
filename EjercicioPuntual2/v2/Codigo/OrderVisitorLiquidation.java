
public class OrderVisitorLiquidation implements IOrderVisitor {
	private double orderTotal;

	public OrderVisitorLiquidation() {
		this.orderTotal = 0;
	}

	public void visit(NonCaliforniaOrder inp_order) {
		orderTotal += inp_order.getOrderAmount();
	}

	public void visit(CaliforniaOrder inp_order) {
		orderTotal += +inp_order.getOrderAmount() + inp_order.getAdditionalTax();
	}

	public void visit(OverseasOrder inp_order) {
		orderTotal += inp_order.getOrderAmount() + inp_order.getAdditionalSH();
	}

	public double getOrderTotal() {
		return orderTotal;
	}
}
