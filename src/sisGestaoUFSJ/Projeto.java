package sisGestaoUFSJ;

public class Projeto {

    public int id;
    public String titulo;
    public String dataInicio;
    public String dataTermino;
    public String agenciaFinanciadora;
    public float valorFinanciado;
    public String objetivo;
    public String descrição;
    public Colaborador[] colaboradores;

    public boolean validade = false;
    public String status = "Em Elaboracao";

}
