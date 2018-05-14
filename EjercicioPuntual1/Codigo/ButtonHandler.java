import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class ButtonHandler implements ActionListener {
	private ReportManager manager;
	
	ButtonHandler(ReportManager m) {
		this.manager = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(ReportManager.EXIT)){
			System.exit(1);			
		}
		if (e.getActionCommand().equals(ReportManager.GET_REPORT)) {
			String selection = (String) manager.getSelectedItem();
			if (selection.equals("") == false) {
				// Crear
				BuilderFactory factory = new BuilderFactory();
				IReportBuilder builder = factory.getReportBuilder(selection);
				ReportDirector director = new ReportDirector(builder);
				director.build();
				// Visitar
				Report report = builder.getReport();
				VisitorDataReportToJModel visitor = new VisitorDataReportToJModel(report.getHeader());
				report.accept(visitor);
				// Mostrar
				this.manager.setTextLblTittle(report.getTittle());
				this.manager.setDataTblData(visitor.getModel());
				this.manager.setTextLblFooter(report.getFooter());
			}
		}
	}
}
