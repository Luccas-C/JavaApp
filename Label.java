import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

public class Label extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private int size = 20;
	private Color cor = new Color(255, 255, 255);
	
	public Label(String texto) {
		super(texto);
		init();
	}
	
	public Label(String texto, Color cor) {
		super(texto);
		this.cor = cor;
		init();
	}
	
	private void init() {
		
		this.setForeground(cor);
		this.setPreferredSize(new Dimension(100, 100));
		this.setFont(new Font(null, Font.BOLD, size));
}
}