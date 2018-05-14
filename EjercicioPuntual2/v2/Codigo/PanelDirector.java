
public class PanelDirector {
	private IPanelBuilder builder;
	
	public PanelDirector(IPanelBuilder builder) {
		this.builder = builder;
	}
	
	public void build() {
		this.builder.addUIControls();
		this.builder.initialize();
	}
	
}
