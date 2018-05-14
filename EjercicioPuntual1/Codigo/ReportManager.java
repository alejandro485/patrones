
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class ReportManager extends JFrame {
	
	public static final String GET_REPORT = "Conseguir Reporte";
	public static final String EXIT = "Exit";
	private JPanel contentPane;
	private JTable tblData;
	private JComboBox cbxReport;
	private JLabel lblTittle;
	private JLabel lblFooter;
	private JScrollPane jScrollPanel;
	private JButton btnGetReport;
	private JButton btnExit;

	/**
	 * Create the frame.
	 */
	public ReportManager() {
		super("Ejercicio puntual, Generador de reportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos los Label
		JLabel lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(12, 17, 70, 15);
		contentPane.add(lblReporte);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 48, 70, 15);
		contentPane.add(lblTitulo);

		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setBounds(12, 75, 70, 15);
		contentPane.add(lblDatos);

		JLabel lblPie = new JLabel("Pie");
		lblPie.setBounds(12, 316, 70, 15);
		contentPane.add(lblPie);
		
		//Creamo un ScrollPane al cual se le asigna una tabla
		this.jScrollPanel = new JScrollPane();
		this.jScrollPanel.setBounds(100, 75, 691, 229);
		contentPane.add(this.jScrollPanel);
		
		//Creamos el ComboBox
		this.cbxReport = new JComboBox();
		
		this.cbxReport.addItem(BuilderFactory.NONE);
		this.cbxReport.addItem(BuilderFactory.COURSES);
		this.cbxReport.addItem(BuilderFactory.STUDENTS);
		this.cbxReport.addItem(BuilderFactory.ALL);
		this.cbxReport.setBounds(100, 12, 204, 24);
		contentPane.add(this.cbxReport);
		
		//Creamos los Label a editar y la tabla de contenido
		this.lblTittle = new JLabel("");
		this.lblTittle.setBounds(100, 48, 691, 15);
		contentPane.add(this.lblTittle);

		this.tblData = new JTable();
		this.tblData.setBounds(100, 75, 691, 229);
		this.jScrollPanel.setViewportView(this.tblData);
		
		

		this.lblFooter = new JLabel("");
		this.lblFooter.setBounds(100, 316, 691, 15);
		contentPane.add(this.lblFooter);

		//Creamos los botones
		this.btnGetReport = new JButton(ReportManager.GET_REPORT);
		this.btnGetReport.setMnemonic(KeyEvent.VK_G);
		this.btnGetReport.setBounds(100, 340, 200, 20);
		contentPane.add(this.btnGetReport);
		
		this.btnExit = new JButton(ReportManager.EXIT);
		this.btnExit.setMnemonic(KeyEvent.VK_E);
		this.btnExit.setBounds(300, 340, 100, 20);
		contentPane.add(this.btnExit);
		
		ButtonHandler bh = new ButtonHandler(this);
		this.cbxReport.addActionListener(bh);
		this.btnGetReport.addActionListener(bh);
		this.btnExit.addActionListener(bh);
		
	}
	public JButton getBtnGetReport() {
		return btnGetReport;
	}
	public void setBtnGetReport(JButton btnGetReport) {
		this.btnGetReport = btnGetReport;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	public JComboBox getCbxReport() {
		return this.cbxReport;
	}
	public String getSelectedItem() {
		return (String) this.cbxReport.getSelectedItem();
	}
	public void setDataTblData(DefaultTableModel dtm) {
		tblData.setModel(dtm);
	}
	public void setTextLblTittle(String text) {
		lblTittle.setText(text);
	}
	public void setTextLblFooter(String text) {
		lblFooter.setText(text);
	}
	public static void main(String[] arg) {
		ReportManager frame = new ReportManager();
		frame.setVisible(true);
	}
	
	
}
