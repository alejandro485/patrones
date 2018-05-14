import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelOverseasOrder implements IPanelBuilder{

	private JPanel pnlOverseasOrder;
	private JTextField txtAmount;
	private JTextField txtSH;
	
	@Override
	public void addUIControls() {
		this.pnlOverseasOrder = new JPanel();
		this.pnlOverseasOrder.setLayout(null);
		
		JLabel lblAmount = new JLabel("Monto de la orden");
		lblAmount.setBounds(12, 12, 263, 23);
		this.pnlOverseasOrder.add(lblAmount);
		
		JLabel lblSH = new JLabel("S & H adicional");
		lblSH.setBounds(12, 47, 263, 23);
		this.pnlOverseasOrder.add(lblSH);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(293, 14, 273, 19);
		this.pnlOverseasOrder.add(txtAmount);
		txtAmount.setColumns(10);
		
		txtSH = new JTextField();
		txtSH.setBounds(293, 49, 273, 19);
		this.pnlOverseasOrder.add(txtSH);
		txtSH.setColumns(10);
	}

	@Override
	public void initialize() {
		this.txtAmount.setText("0");
		this.txtSH.setText("0");
	}

	@Override
	public JPanel getPanel() {
		pnlOverseasOrder.setVisible(true);
		return pnlOverseasOrder;
	}

	@Override
	public IOrder getOrder() {
		double amount = new Double(this.txtAmount.getText()).doubleValue();
		double sh = new Double(this.txtSH.getText()).doubleValue();
		if (amount >= 0 && sh >= 0) {
			return new OverseasOrder(amount, sh);
		}
		throw new IllegalArgumentException();
	}
}