import java.util.ArrayList;
import java.util.List;

public class Faculdade{
    public String nome;
    public String cnpj;
    private static int qtdAlunos = 0;  // Incrementando o contador

    public Faculdade(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    private List<Aluno> alunos = new ArrayList<>();

    void cadastrarAluno(Aluno a){
        for (Aluno alunoExistente : alunos) {
            if (alunoExistente.getCpf() == a.getCpf()) {
                System.out.println("Aluno já cadastrado.");
                return;
            }
        }
        alunos.add(a);
        qtdAlunos++;  // Incrementando o contador
    }

    void editarAluno(Aluno alunoEditado) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCpf() == alunoEditado.getCpf()) {
                alunos.set(i, alunoEditado);
                return;
            }
        }

    }
    public static int getQtdAlunos() {
        return qtdAlunos;
    }
}
