import javax.swing.JPanel;

public interface IPanelBuilder {
	public void addUIControls();
	public void initialize();
	public JPanel getPanel();
	public IOrder getOrder();
}
