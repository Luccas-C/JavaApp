import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ButtonListener implements MouseListener,ActionListener{
	private TextField tituloTextField;
	private TextField sinTextField; 
	private JComboBox genero;
	private JCheckBox assistido;
	private StarRater estrelas;
	private RadioGroup group;

	public ButtonListener(TextField tituloTextField,TextField sinTextField,JComboBox genero,JCheckBox assistido,StarRater estrelas,RadioGroup group) {
		this.tituloTextField = tituloTextField;	
		this.sinTextField = sinTextField;
		this.genero = genero;
		this.assistido = assistido;
		this.estrelas = estrelas;
		this.group = group;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Filmes filmes = new Filmes(tituloTextField.getText(), sinTextField.getText(),(String) genero.getItemAt(genero.getSelectedIndex()), group.getSelectedButtonText(), assistido.isSelected(), estrelas.getSelection());
		System.out.println(filmes.toString());
//		
//		System.out.println("Salvou " + tituloTextField.getText());
//		System.out.println("Salvou " + sinTextField.getText());
//		System.out.println("Genero: " + genero.getItemAt(genero.getSelectedIndex()));
//		
//		if(assistido.isSelected()) {
//			System.out.println("Foi Assistido");
//		}
//		else {
//			System.err.println("Não Foi Assistido");
//		}
//		System.out.println("Avaliação: " + estrelas.getSelection() + " estrelas");
//		System.out.println("O player assistido foi " + group.getSelectedButtonText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicou");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
