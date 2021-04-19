import java.awt.Dimension;
import javax.swing.JTextField;

public class TextField extends JTextField{

	private static final long serialVersionUID = 1L;
	
	public TextField() {
		super();
		init();
	}

	private void init() {
		this.setPreferredSize(new Dimension(200,30));
		this.setBorder(BorderFactory.criar());
	}

}

