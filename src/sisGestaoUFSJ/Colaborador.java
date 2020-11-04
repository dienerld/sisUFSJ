package sisGestaoUFSJ;

import sisGestaoUFSJ.Util.Console;

public class Colaborador {
    public int id;
    public String Nome;
    public String Email;
    public String Cargo;
    public String[] Projetos;
    public boolean professor = false;

    public void printColaborador() {
        Console.printf("Nome: " + this.Nome + " - Email: " + this.Email + "Cargo: " + this.Cargo + " - Projetos: "
                + this.Projetos);
    }
}
