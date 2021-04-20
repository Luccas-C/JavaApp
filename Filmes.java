import javax.swing.JCheckBox;
import javax.swing.JComboBox;
 
public class Filmes {
    private String titulo;
    private String sinopse;
    private String genero;
    private String ondeAssistir;
    private Boolean assistido;
    private int avaliacao;
 
    public Filmes(String titulo, String sinopse, String genero, String ondeAssistir, Boolean assistido, int avaliacao) {
        this.titulo = titulo;    
        this.sinopse = sinopse;
        this.genero = genero;
        this.ondeAssistir = ondeAssistir;
        this.assistido = assistido;
        this.avaliacao = avaliacao;
        }
	@Override
    public String toString() {
        String stringAssistido;
        if(assistido) {
            stringAssistido = "Foi assistido!";
        }
        else {
            stringAssistido ="Não foi assistido!";
        }
        String retorno = "Titulo: " + titulo +"\n"+
        "Sinopse: " + sinopse +"\n"+
        "Genero: " + genero + "\n"+
        "Assistir em: " + ondeAssistir + "\n"+
        "Foi Assistido ?: " + stringAssistido + "\n"+
        "Nota: " + avaliacao + " Estrelas";
        return retorno;        
    }
}

