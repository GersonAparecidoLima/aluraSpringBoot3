package med.voll.api.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    // 1. CONSTRUTOR VAZIO (O que o Hibernate precisa para não dar erro)
    public Endereco() {
    }

    // 2. CONSTRUTOR PARA O SEU CADASTRO (O que você já usa)
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    // 3. GETTERS MANUAIS (Para o Hibernate conseguir ler os dados)
    public String getLogradouro() { return logradouro; }
    public String getBairro() { return bairro; }
    public String getCep() { return cep; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getCidade() { return cidade; }
    public String getUf() { return uf; }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }

}