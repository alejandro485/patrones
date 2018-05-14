
public class BuilderFactory {

	public final static String NONE = "";
	public static final String CA_ORDER = "Orden de california";
	public static final String NON_CA_ORDER = "Orden para fuera de California";
	public static final String OVERSEAS_ORDER = "Orden internacional";
	
	public static IPanelBuilder getPanel(String panel) {
		if (panel.equals(BuilderFactory.CA_ORDER)) {
			return new PanelCaliforniaOrder();
		} else if (panel.equals(BuilderFactory.NON_CA_ORDER)) {
			return new PanelNonCaliforniaOrder();
		} else if (panel.equals(BuilderFactory.OVERSEAS_ORDER)) {
			return new PanelOverseasOrder();
		} else {
			throw new IllegalArgumentException();	
		}
	}
	
}
