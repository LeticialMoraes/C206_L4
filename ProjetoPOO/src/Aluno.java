
public class Aluno implements Matriculado, Comparable<Aluno>{
    private String nome;
    private String cpf;
    private int idade;
    private int matricula;
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void matriculado() {
        System.out.println("O Aluno foi matriculado com sucesso");
    }

    @Override
    public int compareTo(Aluno o) {
        return this.nome.compareTo(o.getNome());
    }

}
