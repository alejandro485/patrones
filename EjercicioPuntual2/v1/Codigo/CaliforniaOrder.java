public class CaliforniaOrder implements IOrder {
	private double orderAmount;
	private double additionalTax;

	public CaliforniaOrder(double inp_orderAmount, double inp_additionalTax) {
		orderAmount = inp_orderAmount;
		additionalTax = inp_additionalTax;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public double getAdditionalTax() {
		return additionalTax;
	}

	public void accept(IOrderVisitor v) {
		v.visit(this);
	}
}
