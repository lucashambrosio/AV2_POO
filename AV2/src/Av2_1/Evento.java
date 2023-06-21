package Av2_1;
import java.util.ArrayList;

class Evento {
    private String nome;
    private String local;
    private String data;

    private String hora;

    public Evento(String nome, String local, String data, String hora) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.hora = hora;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class Ingresso {
    private int numero;
    private String tipo;
    private double preco;

    public Ingresso(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public VendaSite() {
        ingressos = new ArrayList<Ingresso>();
    }


    public void insereVenda(Ingresso ingresso) {
        ingressos.add(ingresso);
    }


    public int getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(int qtdeMax) {
        this.qtdeMax = qtdeMax;
    }


    public boolean validaQtdeIngresso() {
        return ingressos.size() < qtdeMax;
    }
}

