import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Arquivo {

    // escrevendo o aluno no arquivo
    public void escrever(Aluno aluno){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            // Estruturas básicas para escrita em um arquivo
            os = new FileOutputStream("Teste.txt",true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Escrevendo as informações do funcionário
            bw.write("+++ Aluno +++\n");
            bw.write(aluno.getNome()+"\n");
            bw.write(aluno.getCpf()+"\n");
            bw.write(aluno.getIdade()+"\n");
            bw.write(aluno.getCurso()+"\n");
            bw.write(aluno.getMatricula()+"\n");

        }catch (Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // lendo as informações do aluno no arquivo
    public ArrayList<Aluno> ler(){
        // Criando array list que armazena os livros encontrados no arquivo
        ArrayList<Aluno> encontreiAlunoNoArquivo = new ArrayList<>();

        // Estruturas que servirão para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para ler o arquivo

        try{
            is = new FileInputStream("Teste.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);


            // Posiciando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e rodando o código enquanto tiver informações no txt
            while(linhaLer!=null){
                // Verificando se encontramos a flag que indica o início de um livro
                if(linhaLer.contains("+++ Aluno +++")){
                    Aluno auxAluno = new Aluno();
                    auxAluno.setNome(br.readLine());
                    auxAluno.setCpf(br.readLine());
                    auxAluno.setIdade(Integer.parseInt(br.readLine()));
                    auxAluno.setCurso(br.readLine());
                    auxAluno.setMatricula(Integer.parseInt(br.readLine()));

                    encontreiAlunoNoArquivo.add(auxAluno);

                }
                // Passando para a próxima linha
                linhaLer = br.readLine();
            }
        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }
        return encontreiAlunoNoArquivo;
    }

    public void editarAluno(Aluno alunoEditado) {
        ArrayList<Aluno> alunos = ler();
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getCpf().equals(alunoEditado.getCpf())) {
                alunos.set(i, alunoEditado);
                break;
            }
        }
        reescreverAlunos(alunos);
    }

    private void reescreverAlunos(ArrayList<Aluno> alunos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Teste.txt"))) {
            for (Aluno aluno : alunos) {
                writer.println("+++ Aluno +++");
                writer.println(aluno.getNome());
                writer.println(aluno.getCpf());
                writer.println(aluno.getIdade());
                writer.println(aluno.getCurso());
                writer.println(aluno.getMatricula());

            }
        } catch (IOException e) {
            System.out.println("Erro ao reescrever o arquivo de alunos: " + e.getMessage());
        }
    }

    public void removerAluno(Aluno aluno) {
        ArrayList<Aluno> alunos = this.ler();
        Iterator<Aluno> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            Aluno a = iterator.next();
            if (a.getCpf().equals(aluno.getCpf())) {
                iterator.remove();
                System.out.println("Aluno removido!");
                break;
            }
        }
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("Teste.txt", false);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            for (Aluno a : alunos) {
                bw.write("+++ Aluno +++");
                bw.newLine();
                bw.write(a.getNome()+ "\n");
                bw.write(a.getCpf()+ "\n");
                bw.write(a.getIdade()+ "\n");
                bw.write(a.getCurso()+ "\n");
                bw.write(a.getMatricula()+ "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}