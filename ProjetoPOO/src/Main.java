import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arquivo arq = new Arquivo();
        Faculdade f = new Faculdade("INATEL", "12345");
        Aluno a = new Aluno();
        boolean flag = true;

        while (flag) {
            System.out.println("Bem vindo ao centro de cadastro de Alunos do: " +f.nome);
            System.out.println("Digite sua opção: ");
            System.out.println("1 - Adicionar um aluno");
            System.out.println("2 - Ler Arquivo");
            System.out.println("3 - Ler o Arquivo de forma ordenanda: Alunos por ordem alfabetica");
            System.out.println("4 - Quantidade de alunos cadastrados na Faculdade");
            System.out.println("5 - Editar Aluno");
            System.out.println("6 - Remover Aluno");
            System.out.println("7 - Sair");
            int op = sc.nextInt();
            sc.nextLine();
            ArrayList<Aluno> funcs1 = arq.ler();


            switch (op) {
                case 1:
                    System.out.println("+++ Aluno +++");
                    System.out.println("Digite o Nome: ");
                    a.setNome(sc.nextLine());
                    System.out.println("Digite o CPF: ");
                    a.setCpf(sc.nextLine());
                    try {
                        System.out.println("Digite a idade: ");
                        a.setIdade(Integer.parseInt(sc.nextLine()));
                        if(a.getIdade()<=0) {
                            throw new DadoInvalidoException();
                        }

                    }catch (DadoInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                        break;
                    }
                    System.out.println("Digite o curso: ");
                    a.setCurso(sc.nextLine());
                    try {
                        System.out.println("Digite a matricula: ");
                        a.setMatricula(sc.nextInt());
                        if(a.getMatricula()<=0) {
                            throw new DadoInvalidoException();
                        }

                    }catch (DadoInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                        break;
                    }

                    f.cadastrarAluno(a);
                    a.matriculado();
                    arq.escrever(a);
                    break;

                case 2:
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("+++ Aluno +++");
                    for (int i = 0; i <funcs1.size(); i++) {
                        System.out.println("Nome: " +funcs1.get(i).getNome());
                        System.out.println("CPF: " +funcs1.get(i).getCpf());
                        System.out.println("Idade: " +funcs1.get(i).getIdade());
                        System.out.println("Curso: " +funcs1.get(i).getCurso());
                        System.out.println("Matricula: " +funcs1.get(i).getMatricula());
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println();
                    Collections.sort(funcs1);
                    System.out.println("------------------");
                    System.out.println("+++ Aluno +++");
                    for (int i = 0; i <funcs1.size(); i++) {
                        System.out.println("Nome: " +funcs1.get(i).getNome());
                        System.out.println("CPF: " +funcs1.get(i).getCpf());
                        System.out.println("Idade: " +funcs1.get(i).getIdade());
                        System.out.println("Curso: " +funcs1.get(i).getCurso());
                        System.out.println("Matricula: " +funcs1.get(i).getMatricula());
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Quantidade de Alunos Cadastrados na Faculdade: " + Faculdade.getQtdAlunos());
                    break;
                case 5:
                    // Editar dados de um aluno
                    System.out.println("+++ Editar Aluno +++");
                    System.out.println("Digite o CPF do aluno que deseja editar: ");
                    String cpfEditar = sc.nextLine();

                    Aluno alunoEditado = null;
                    for (Aluno alunoExistente : funcs1) {
                        if (alunoExistente.getCpf().equals(cpfEditar)) {
                            alunoEditado = alunoExistente;
                            break;
                        }
                    }
                    System.out.println("Voce esta editando o Aluno cujo o CPF escolhido é: "+cpfEditar);
                    if (alunoEditado != null) {
                        System.out.println("Digite o nome: ");
                        alunoEditado.setNome(sc.nextLine());
                        System.out.println("Digite o CPF: ");
                        alunoEditado.setCpf(sc.nextLine());
                        try {
                            System.out.println("Digite a idade: ");
                            alunoEditado.setIdade(Integer.parseInt(sc.nextLine()));
                            if(alunoEditado.getIdade()<=0) {
                                sc.nextLine(); // Consumir a nova linha
                                throw new DadoInvalidoException();
                            }
                        } catch (DadoInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                            break;
                        }

                        System.out.println("Digite o curso: ");
                        alunoEditado.setCurso(sc.nextLine());

                        System.out.println("Digite a  matricula: ");
                        try {
                            alunoEditado.setMatricula(sc.nextInt());
                            sc.nextLine(); // Consumir a nova linha
                            if(alunoEditado.getMatricula() <= 0) {
                                throw new DadoInvalidoException();
                            }
                        } catch (DadoInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                            break;
                        }

                        // Chame a função de edição no arquivo e na faculdade
                        arq.editarAluno(alunoEditado);
                        f.editarAluno(alunoEditado);
                        System.out.println("Aluno editado com sucesso.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do aluno que deseja remover");
                    a.setNome(sc.nextLine());
                    System.out.println("Digite o cpf do aluno que deseja remover: ");
                    a.setCpf(sc.nextLine());
                    System.out.println("Digite a idade do aluno que deseja remover: ");
                    a.setIdade(Integer.parseInt(sc.nextLine()));
                    System.out.println("Digite o curso do aluno que deseja remover remover: ");
                    a.setCurso(sc.nextLine());
                    System.out.println("Digite a matricula do aluno que deseja remover: ");
                    a.setMatricula(sc.nextInt());

                    arq.removerAluno(a);
                    break;

                case 7:
                    // Sair do menu
                    flag=false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }

        }
    }
}