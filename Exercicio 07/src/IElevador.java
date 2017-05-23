/*
 * Universidade Federal de Santa Catarina.
 * CTC - Centro Tecnologico - http://ctc.ufsc.br
 * INE - Departamento de Informatica e Estatistica - http://inf.ufsc.br
 */
 
/**
 *
 * @author Jean Hauck <jean.hauck at ufsc.br>
 * @date   11/09/2015
 */
public interface IElevador {

    public int getCapacidade();
    public int getTotalPessoas();
    public String descer();
    public String entraPessoa();
    public String saiPessoa();
    public String subir();
    public void setTotalAndaresPredio(int totalAndaresPredio);
    public int getTotalAndaresPredio();
    public int getAndarAtual();
    
}
