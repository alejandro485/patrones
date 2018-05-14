import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ButtonHandler implements ActionListener {
	private OrderManager manager;
	private ListOrders listOrders;
	private IPanelBuilder panel;

	public ButtonHandler(OrderManager objManager) {
		this.manager = objManager;
		this.listOrders = new ListOrders();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(OrderManager.EXIT)) {
			System.exit(1);
		}
		if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
			IOrder order = this.panel.getOrder();
			this.listOrders.add(order);
			OrderVisitorToTableModel visitor = new OrderVisitorToTableModel();
			this.visitCollection(visitor);
			this.manager.setDataTable(visitor.getTableModel());
		}
		if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
			OrderVisitorLiquidation visitor = new OrderVisitorLiquidation();
			this.visitCollection(visitor);
			String total = "USD " + visitor.getOrderTotal();
			this.manager.setTotalValue(total);
		}
		if (e.getActionCommand().equals(OrderManager.CLEAR)) {
			this.listOrders.clear();
			this.manager.setDataTable(new DefaultTableModel());
			this.manager.setTotalValue("");
		}
		if (e.getSource() == manager.getCbxOrderType()) {
			String orderType = manager.getOrderType();
			this.panel = BuilderFactory.getPanel(orderType);
			PanelDirector director = new PanelDirector(this.panel);
			director.build();
			this.manager.displayNewUI(this.panel.getPanel());
		}
	}
	
	private void visitCollection(IOrderVisitor visitor) {
		while(this.listOrders.hasNext()) {
			IOrder order = (IOrder) this.listOrders.next();
			order.accept(visitor);
		}
	}
	
}