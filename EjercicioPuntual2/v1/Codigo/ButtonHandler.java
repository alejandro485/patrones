import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ButtonHandler implements ActionListener {
	private OrderManager manager;
	private AllOrders allOrders;
	private IPanelBuilder panel;

	public ButtonHandler(OrderManager objManager) {
		this.manager = objManager;
		this.allOrders = new AllOrders();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(OrderManager.EXIT)) {
			System.exit(1);
		}
		if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
			IOrder order = this.panel.getOrder();
			this.allOrders.add(order);
			OrderVisitorToTableModel visitor = new OrderVisitorToTableModel();
			this.allOrders.accept(visitor);
			this.manager.setDataTable(visitor.getTableModel());
		}
		if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
			OrderVisitorLiquidation visitor = new OrderVisitorLiquidation();
			this.allOrders.accept(visitor);
			String total = "USD " + visitor.getOrderTotal();
			this.manager.setTotalValue(total);
		}
		if (e.getActionCommand().equals(OrderManager.CLEAR)) {
			this.allOrders.clear();
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
	
}