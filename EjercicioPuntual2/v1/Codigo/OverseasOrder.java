public class OverseasOrder implements IOrder {
	private double orderAmount;
	private double additionalSH;

	public OverseasOrder(double inp_orderAmount, double inp_additionalSH) {
		orderAmount = inp_orderAmount;
		additionalSH = inp_additionalSH;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public double getAdditionalSH() {
		return additionalSH;
	}

	public void accept(IOrderVisitor v) {
		v.visit(this);
	}
}
