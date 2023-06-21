import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private String endereco;

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

class UsuarioComum extends Pessoa {
    private String login;
    private String senha;

    public UsuarioComum(String nome, String endereco, String login, String senha) {
        super(nome, endereco);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

class Promotor extends Pessoa {
    private String cnpj;

    public Promotor(String nome, String endereco, String cnpj) {
        super(nome, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

class Evento {
    private String titulo;
    private String data;
    private Promotor promotor;
    private ArrayList<Ingresso> ingressos;
    private String hora;

    public Evento(String titulo, String data, Promotor promotor, String hora) {
        this.titulo = titulo;
        this.data = data;
        this.promotor = promotor;
        this.hora = hora;
        this.ingressos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}

class Ingresso {
    private String tipo;
    private double preco;

    public Ingresso(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

class VendaSite {
    private ArrayList<Ingresso> ingressos;
    private int qtdeMax;

    public VendaSite(int qtdeMax) {
        this.ingressos = new ArrayList<>();
        this.qtdeMax = qtdeMax;
    }

    public void insereVenda(Ingresso ingresso) {
        if (validaQtdeIngresso()) {
            ingressos.add(ingresso);
            System.out.println("Ingresso cadastrado com sucesso!");
        } else {
            System.out.println("Quantidade máxima de ingressos atingida. Não é possível cadastrar mais ingressos.");
        }
    }

    public boolean validaQtdeIngresso() {
        return ingressos.size() < qtdeMax;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {
        this.qtdeMax = qtdeMax;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastrar Pessoa Física
        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();
        System.out.print("Digite o endereço da pessoa: ");
        String enderecoPessoa = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nomePessoa, enderecoPessoa);

        // Cadastrar Promotor
        System.out.print("Digite o nome do promotor: ");
        String nomePromotor = scanner.nextLine();
        System.out.print("Digite o endereço do promotor: ");
        String enderecoPromotor = scanner.nextLine();
        System.out.print("Digite o CNPJ do promotor: ");
        String cnpjPromotor = scanner.nextLine();
        Promotor promotor = new Promotor(nomePromotor, enderecoPromotor, cnpjPromotor);

        // Cadastrar Evento
        System.out.print("Digite o título do evento: ");
        String tituloEvento = scanner.nextLine();
        System.out.print("Digite a data do evento: ");
        String dataEvento = scanner.nextLine();
        System.out.print("Digite a hora do evento: ");
        String horaEvento = scanner.nextLine();
        Evento evento = new Evento(tituloEvento, dataEvento, promotor, horaEvento);

        // Cadastrar Ingressos
        System.out.println("Digite as informações dos ingressos (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("Tipo do ingresso: ");
            String tipoIngresso = scanner.nextLine();
            if (tipoIngresso.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.print("Preço do ingresso: ");
            double precoIngresso = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer de entrada
            Ingresso ingresso = new Ingresso(tipoIngresso, precoIngresso);
            evento.adicionarIngresso(ingresso);
        }

        // Criar um objeto do tipo VendaSite e adicionar o conteúdo do atributo qtdeMax
        System.out.print("Digite a quantidade máxima de ingressos para venda: ");
        int qtdeMaxIngressos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada
        VendaSite vendaSite = new VendaSite(qtdeMaxIngressos);

        // Cadastrar os ingressos para vender no site
        for (Ingresso ingresso : evento.getIngressos()) {
            vendaSite.insereVenda(ingresso);
        }

        scanner.close();
    }
}
