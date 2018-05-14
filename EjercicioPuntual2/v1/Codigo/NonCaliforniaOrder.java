public class NonCaliforniaOrder implements IOrder {
	private double orderAmount;

	public NonCaliforniaOrder(double inp_orderAmount) {
		orderAmount = inp_orderAmount;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void accept(IOrderVisitor v) {
		v.visit(this);
	}
}
