public class Conta {
    private double saldo;
    private static int qtdClientes = 0;
    private Cliente[] clientes;

    public Conta() {
        setClientes(new Cliente[3]);
    }

    //Comportamento de Conta
    public void sacar(double valor){
        if(saldo >= valor){
            this.saldo -= valor;
        }else{
            System.out.println("Saldo Insuficiente");
        }
    }

    public void deposita(double valor){
        this.saldo += valor;
    }

    public void extrato(){
        this.saldo = saldo;
    }

    //Getters e Setters
    public double getSaldo(){
        return this.saldo;
    }
    public Cliente[] getClientes() {
        qtdClientes ++;
        return clientes;
    }
    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public static int getQtdClientes(){
        return qtdClientes;
    }
}
