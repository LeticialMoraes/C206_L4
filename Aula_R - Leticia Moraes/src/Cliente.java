public class Cliente {
    private static int cont=0;
    // Atributos do objeto
    private int id; // Id do cliente
    private String nome; // Nome do cliente

    public Cliente(String nome) {
        // Incrementar o contador
        cont++;

        // Atribui o valor ao id
        id = cont;

        // Atribuindo o valor ao nome
        this.nome = nome;

    }

    // Método para mostrar infos
    public void mostrarInfos(){
        System.out.println("Nome: "+this.nome);
        System.out.println("ID: "+this.id);
    }

    // Encapsulamento - Modificadores de acesso

    public static int getCont() {
        return cont;
    }

}
