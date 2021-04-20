import java.awt.*;
import javax.swing.*;
import java.util.List;

public class Main {
 public static void main(String[] args) {
	 JFrame window = new JFrame();
	 
	 Container mainContainer = new Container();
	 mainContainer.setLayout(new BorderLayout());
	 
	 JPanel left = new JPanel();
	 	JLabel image = new JLabel(new ImageIcon("src/fiap.png"));
	 	left.add(image);
	 	
	 	
	 JPanel middle = new JPanel();	
	 	middle.add(new Label("Título", Color.BLACK));
	 TextField tituloTextField = new TextField();
	 	middle.add(tituloTextField);
	 
	 	middle.add(new Label("Sinopse", Color.BLACK));
	 TextField sinTextField = new TextField();
	 	middle.add(sinTextField);
	 
	 	middle.add(new Label("Gênero", Color.BLACK));
	 	String[] genero = {"Ação", "Aventura", "Suspense"};
	 	JComboBox generos = new JComboBox<String>(genero);
	 	middle.add(generos);
	 	
		JButton buttonSave = new JButton("Salvar");
		JButton buttonCancel = new JButton("Cancelar");
		middle.add(buttonSave);
		middle.add(buttonCancel);
		middle.setLayout(new GridLayout(10,1));
	
		
		JPanel right = new JPanel();
		right.add(new Label("Onde Assistir", Color.BLACK));
		
		List<String> listaAssistir = List.of("Netflix", "Prime Vídeo", "Pirate Bay                                      ");
		RadioGroup group = new RadioGroup(listaAssistir);
		right.add(group);
		group.setLayout(new GridLayout(3,1));
		
		JCheckBox assistido = new JCheckBox("Assistido");
		right.add(assistido);
		
		StarRater estrelas = new StarRater(5 , 2.5f);
		right.add(estrelas);
		right.setLayout(new GridLayout(4,1));
		
		buttonSave.addActionListener(new ButtonListener(tituloTextField,sinTextField,generos,assistido,estrelas,group));
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.add("Cadastro",mainContainer);
		tabs.add("Lista",new JPanel());
		
		mainContainer.add(left,BorderLayout.WEST);
		mainContainer.add(middle,BorderLayout.CENTER);
		mainContainer.add(right,BorderLayout.EAST);
		
		window.add(tabs);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 500);
		window.setVisible(true);
	
}
}