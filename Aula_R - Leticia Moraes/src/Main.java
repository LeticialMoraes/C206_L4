public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João");

        Cliente cliente2 = new Cliente("Pablo");
        Cliente cliente3 = new Cliente("Teste");

        Cliente[] clientes = new Cliente[3];
        clientes[0] = cliente1;
        clientes[1] = cliente2;
        clientes[2] = cliente3;

        Conta conta = new Conta();
        conta.setClientes(clientes);

        System.out.println(conta.getSaldo());

        conta.deposita(700);

        System.out.println(conta.getSaldo());

        conta.sacar(300);

        System.out.println(conta.getSaldo());

        conta.sacar(800);
        System.out.println("Quantidade de clienes: "+Cliente.getCont());
    }
}