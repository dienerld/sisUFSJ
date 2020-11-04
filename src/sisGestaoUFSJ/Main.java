package sisGestaoUFSJ;

import sisGestaoUFSJ.Util.*;

public class Main {

    static Projeto[] projetos = new Projeto[100];
    static Colaborador[] colaboradores = new Colaborador[100];
    static int numProjetos = 0;
    static int id = -1;

    static String arq = "/home/dnr/OneDrive/sisGestaoUFSJ/src/sisGestaoUFSJ/Projeto1.dih";
    static String conteudo = Arquivo.Read(arq);
    static String[] keyWord = conteudo.split(";");
    static int keyIndex = 0;

    static String verAutomatico = "/home/dnr/OneDrive/sisGestaoUFSJ/src/sisGestaoUFSJ/configAutomatico.conf";
    static int automatic = Integer.parseInt(Arquivo.Read(verAutomatico).split("\n")[1]);

    static String arqUser = "/home/dnr/OneDrive/sisGestaoUFSJ/src/sisGestaoUFSJ/colab.dih";
    static String conteudoUser = Arquivo.Read(arqUser);
    static String[] keyWordUser = conteudoUser.split(";");
    static int keyIndexUser = 0;

    public static void main(String[] args) {

        System.out.println(automatic);
        int opcao = 0;
        do {
            Console.println("1 - Cadastrar Novo Projeto");
            Console.println("2 - Alterar Projeto");
            Console.println("3 - Listar Projetos");
            Console.printf("OPÇÃO: ");
            opcao = Integer.parseInt(Console.readLine());

            switch (opcao) {
                case 1:
                    cadastrarProjeto();
                    break;

                case 2:
                    Console.printf("1 - Alterar Status\n2 - Inserir Colaboradores\nOPCAO: ");
                    switch (Integer.parseInt(Console.readLine())) {
                        case 1:
                            FunctionProjetos.printTituloProjetos(projetos, numProjetos);
                            Console.printf("Digite o ID do Projeto: ");
                            id = Integer.parseInt(Console.readLine());

                            break;
                        case 2:
                            FunctionProjetos.printTituloProjetos(projetos, numProjetos);
                            Console.printf("Digite o ID do Projeto: ");
                            id = Integer.parseInt(Console.readLine());

                            projetos[id] = inserirColaboradores(projetos[id],
                                    FunctionProjetos.contaColaboradores(projetos[id]));
                        default:
                            break;
                    }
                    Console.println("Continuar: \n1 - Sim\n2 - Não");
                    Console.printf("OPÇÃO: ");
                    opcao = Integer.parseInt(Console.readLine()); // alterarProjeto(opcao);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } while (opcao != 10);
    }

    public static void cadastrarProjeto() {
        Projeto projeto = new Projeto();

        if (automatic == 1) {
            projeto.titulo = keyWord[keyIndex];
            keyIndex++;
        } else {
            Console.printf("Digite o Titulo: ");
            projeto.titulo = Console.readLine();
        }

        if (automatic == 1) {
            projeto.dataInicio = keyWord[keyIndex];
            keyIndex++;
        } else {
            Console.printf("Digite a Data de Inicio: ");
            projeto.dataInicio = Console.readLine();
        }

        if (automatic == 1) {
            projeto.dataTermino = keyWord[keyIndex];
            keyIndex++;
        } else {
            Console.printf("Digite a Data de Termino: ");
            projeto.dataTermino = Console.readLine();
        }

        if (automatic == 1) {
            projeto.agenciaFinanciadora = keyWord[4];
            keyIndex++;
        } else {
            Console.printf("Digite Agencia Financiadoora: ");
            projeto.agenciaFinanciadora = Console.readLine();
        }

        if (automatic == 1) {
            projeto.valorFinanciado = Integer.parseInt(keyWord[keyIndex]);
            keyIndex++;
        } else {
            Console.printf("Digite o Valor Financiado: ");
            projeto.valorFinanciado = Float.parseFloat(Console.readLine());
        }
        if (automatic == 1) {
            projeto.objetivo = keyWord[keyIndex];
            keyIndex++;
        } else {
            Console.printf("Digite o Objetivo: ");
            projeto.objetivo = Console.readLine();
        }
        if (automatic == 1) {
            projeto.descrição = keyWord[keyIndex];
            keyIndex++;
        } else {
            Console.printf("Digite a Descricao: ");
            projeto.descrição = Console.readLine();
        }
        projeto.colaboradores = new Colaborador[10];
        projeto.id = numProjetos;
        projetos[numProjetos] = projeto;
        Console.printf("Inserir Colaboradores:\n1 - Sim\n2 - Nao\nOPCAO: ");
        switch (Integer.parseInt(Console.readLine())) {
            case 1:
                projetos[numProjetos] = inserirColaboradores(projeto, 0);
                break;
            case 2:
                break;
            default:
                Console.println("Opcao Invalida!");
                break;
        }
        numProjetos++;

    }

    public static Projeto inserirColaboradores(Projeto projeto, int tamColab) {
        int opcao = 1;
        int cargo = 0;
        do {
            Colaborador pessoa = new Colaborador();
            if (automatic == 1) {
                cargo = Integer.parseInt(keyWordUser[keyIndexUser]);
                keyIndexUser++;
            } else {
                Console.printf(
                        "Escolha o Cargo 1 - Orientador\n2 - Pesquisador\n3 - Alunoa de Mestrado\n4 - Alunos de Graduação\n0 - Sair\nOPCAO: ");
                cargo = Integer.parseInt(Console.readLine());
            }
            switch (cargo) {
                case 1:
                    pessoa.Cargo = "Orientador";
                    pessoa.professor = true;
                    projeto.validade = true;
                    break;
                case 2:
                    pessoa.Cargo = "Pesquisador";
                    break;
                case 3:
                    pessoa.Cargo = "Aluno de Mestrado";
                    break;
                case 4:
                    pessoa.Cargo = "Aluno de Graduação";
                    break;
                case 0:
                    return projeto;
                default:
                    if (cargo > 4)
                        Console.println("Opcao Invalida!");
                    break;
            }
            if (cargo > 0) {
                if (automatic == 1) {
                    pessoa.Nome = keyWordUser[keyIndexUser];
                    keyIndexUser++;
                } else {
                    Console.printf("Digite o Nome: ");
                    pessoa.Nome = Console.readLine();
                }
                if (automatic == 1) {
                    pessoa.Email = keyWordUser[keyIndexUser];
                    keyIndexUser++;
                } else {
                    Console.printf("Digite o Email: ");
                    pessoa.Email = Console.readLine();
                }
                pessoa.id = tamColab;

                pessoa.Projetos = new String[10];

                pessoa = verificarColaborador(pessoa);
                pessoa = projetosPessoais(pessoa, projeto.titulo);

                if (pessoa.id == tamColab) {
                    colaboradores[tamColab] = pessoa;
                    projeto.colaboradores[tamColab] = pessoa;
                    tamColab++;
                } else {
                    projeto.colaboradores[pessoa.id] = pessoa;
                }
            }
        } while (opcao != 0);
        if (projeto.validade && (tamColab - 1) < 1) {
            projeto.validade = false;
        }
        return projeto;
    }

    public static Colaborador projetosPessoais(Colaborador pessoa, String tituloProjeto) {
        int i = 0;
        while (pessoa.Projetos[i] != null) {
            i++;
        }
        pessoa.Projetos[i] = tituloProjeto;
        return pessoa;
    }

    public static Colaborador verificarColaborador(Colaborador pesssoa) {
        int tamVetor = 0;
        while (colaboradores[tamVetor] != null) {
            if (pesssoa.Nome.equalsIgnoreCase(colaboradores[tamVetor].Nome)) {
                if (pesssoa.Email.equalsIgnoreCase(colaboradores[tamVetor].Email)) {
                    pesssoa = colaboradores[tamVetor];
                    Console.println("EntrouIF");
                    return pesssoa;
                }
            }
            tamVetor++;
        }
        return pesssoa;
    }

}
