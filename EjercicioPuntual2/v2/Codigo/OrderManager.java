import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class OrderManager extends JFrame {
	public static final String GET_TOTAL = "Liquidar";
	public static final String CREATE_ORDER = "Crear orden";
	public static final String EXIT = "Salir";
	public static final String CLEAR = "Limpiar";

	private JComboBox cbxOrderType;
	private JPanel pnlOrder;
	private JScrollPane scrlTable;
	private JLabel lblValue;
	private JTable tblOrders;

	public OrderManager() {
		super("Ordenes de envio");
		
		JButton btnExit = new JButton(OrderManager.EXIT);
		JButton btnGetTotal = new JButton(OrderManager.GET_TOTAL);
		JButton btnCreateOrder = new JButton(OrderManager.CREATE_ORDER);
		JButton btnClear = new JButton(OrderManager.CLEAR);
		JLabel labelL = new JLabel("Liquidacion de ordenes:");
		JLabel lblOrderType = new JLabel("Tipo de orden:");
		this.cbxOrderType = new JComboBox();
		this.cbxOrderType.addItem(BuilderFactory.CA_ORDER);
		this.cbxOrderType.addItem(BuilderFactory.NON_CA_ORDER);
		this.cbxOrderType.addItem(BuilderFactory.OVERSEAS_ORDER);
		this.pnlOrder = new JPanel(new GridLayout(1,1));
		this.scrlTable = new JScrollPane();
		this.tblOrders = new JTable();
		scrlTable.setViewportView(this.tblOrders);
		this.lblValue = new JLabel("");
		ButtonHandler objButtonHandler = new ButtonHandler(this);
		
		btnExit.setBounds(179, 394, 147, 25);
		btnGetTotal.setBounds(12, 394, 155, 25);
		btnCreateOrder.setBounds(12, 357, 155, 25);
		btnClear.setBounds(179, 357, 147, 25);
		labelL.setBounds(344, 357, 246, 25);
		lblOrderType.setBounds(12, 12, 302, 15);
		this.cbxOrderType.setBounds(332, 7, 258, 24);
		this.pnlOrder.setBounds(12, 39, 578, 111);
		this.scrlTable.setBounds(12, 164, 578, 181);
		this.lblValue.setBounds(344, 394, 246, 24);
		
		getContentPane().setLayout(null);
		getContentPane().add(this.cbxOrderType);
		getContentPane().add(lblOrderType);
		getContentPane().add(this.pnlOrder);
		getContentPane().add(this.scrlTable);
		getContentPane().add(btnExit);
		getContentPane().add(btnCreateOrder);
		getContentPane().add(btnGetTotal);
		getContentPane().add(labelL);
		getContentPane().add(this.lblValue);
		getContentPane().add(btnClear);

		btnExit.addActionListener(objButtonHandler);
		btnGetTotal.addActionListener(objButtonHandler);
		btnCreateOrder.addActionListener(objButtonHandler);
		btnClear.addActionListener(objButtonHandler);
		cbxOrderType.addActionListener(objButtonHandler);
		cbxOrderType.setSelectedIndex(0);
	}

	public static void main(String[] args) {
		JFrame frame = new OrderManager();
		frame.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
		frame.setSize(610, 440);
		frame.setVisible(true);
	}

	public void setTotalValue(String msg) {
		this.lblValue.setText(msg);
	}

	public String getOrderType() {
		return (String) this.cbxOrderType.getSelectedItem();
	}
	
	public JComboBox getCbxOrderType() {
		return this.cbxOrderType;
	}

	public void displayNewUI(JPanel panel) {
		this.pnlOrder.removeAll();
		this.pnlOrder.add(panel);
		this.pnlOrder.validate();
		this.pnlOrder.setBounds(12, 39, 578, 111);
		this.validate();
	}
	
	public void setDataTable(DefaultTableModel dtm) {
		this.tblOrders.setModel(dtm);
	}
}
