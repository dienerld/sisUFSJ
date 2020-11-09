package sisGestaoUFSJ.Util;

import sisGestaoUFSJ.Projeto;

public class FunctionProjetos {

    public void printProjetos(Projeto projeto) {
        String Orientador = "";
        String[] Equipe;

        int tamEquipe = 0;

        for (int i = 0; i < projeto.colaboradores.length; i++) {
            if (projeto.colaboradores[i].professor && projeto.colaboradores[i].Cargo.equals( "Orientaddor")) {
                Orientador = projeto.colaboradores[i].Nome;
            } else {
                Equipe[tamEquipe] = projeto.colaboradores[i].Nome;
                tamEquipe++;
            }
        }
        if (projeto.validade) {
            Console.println(String.format(
                    "Titulo: %s\nOrientador: %s\nDataInicio: %s\nDataTermino: %s\nAgenciaFinanciadora: %s\nValorFinanciado: %d\nObjetivo: %s\nDescrição",
                    projeto.titulo, Orientador, projeto.dataInicio, projeto.dataTermino, projeto.agenciaFinanciadora,
                    projeto.valorFinanciado, projeto.objetivo, projeto.descrição));
            for (int i = 0; i < Equipe.length; i++) {
                printColaboradores(Equipe[i]);
            }
        } else {
            return;
        }
    }

    public void printColaboradores(String nome) {
        Console.printf(nome);
    }

    public static int contaColaboradores(Projeto projeto) {
        int total = 0;
        while (projeto.colaboradores[total + 1] != null) {
            total += 1;
        }
        return total;
    }

    public static void printTituloProjetos(Projeto[] projetos, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            Console.printf(projetos[i].id + " - " + projetos[i].titulo + "\n");
        }
    }

}
