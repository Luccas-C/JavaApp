import javax.swing.JTextArea;

public class TextArea extends JTextArea{
	private static final long serialVersionUID = 1L;
	
	private int linhas = 10;
	private int colunas = 30;
	
	public TextArea() {
		super();
		init();
	}

	private void init() {
		this.setRows(linhas);
		this.setColumns(colunas);
		this.setBorder(BorderFactory.criar());
		
	}
}
