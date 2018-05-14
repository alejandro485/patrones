import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class OrderVisitorToTableModel implements IOrderVisitor {
	
	private DefaultTableModel tableModel;
	
	public OrderVisitorToTableModel() {
		this.tableModel = new DefaultTableModel();
		Vector headers = new Vector();
		headers.add("Tipo");
		headers.add("Monto");
		headers.add("Impuestos");
		headers.add("S & H");
		this.tableModel.setColumnIdentifiers(headers);
	}

	@Override
	public void visit(NonCaliforniaOrder nco) {
		Vector row = new Vector();
		row.add(BuilderFactory.NON_CA_ORDER);
		row.add(nco.getOrderAmount());
		this.tableModel.addRow(row);
	}

	@Override
	public void visit(CaliforniaOrder co) {
		Vector row = new Vector();
		row.add(BuilderFactory.CA_ORDER);
		row.add(co.getOrderAmount());
		row.add(co.getAdditionalTax());
		this.tableModel.addRow(row);
	}

	@Override
	public void visit(OverseasOrder oo) {
		Vector row = new Vector();
		row.add(BuilderFactory.OVERSEAS_ORDER);
		row.add(oo.getOrderAmount());
		row.add(null);
		row.add(oo.getAdditionalSH());
		this.tableModel.addRow(row);
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
