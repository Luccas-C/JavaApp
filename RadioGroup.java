import java.util.Enumeration;
import java.util.List;
 
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class RadioGroup extends JPanel{
 
    private static final long serialVersionUID = 1L;
 
    private ButtonGroup grupo = new ButtonGroup();
    private List<String> opcoes;

    public RadioGroup(List<String> listaDeOpcoes) {
        this.opcoes = listaDeOpcoes;
        init();    
    }
 
    private void init() {
        opcoes.forEach(opcao -> {
            JRadioButton botao = new JRadioButton(opcao);
            grupo.add(botao);
            this.add(botao);
        });
    }

    public String getSelectedButtonText() {
        for (Enumeration<AbstractButton> bts = grupo.getElements(); bts.hasMoreElements();) {
             AbstractButton botao = bts.nextElement();

             if (botao.isSelected()) {
                 return botao.getText();
             }
        }
        return "";
     }
 
}
