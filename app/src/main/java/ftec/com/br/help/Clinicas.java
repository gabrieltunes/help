package ftec.com.br.help;

import java.io.Serializable;

/**
 * Created by ADM on 15/06/2018.
 */

public class Clinicas implements Serializable {

    private String nome;
    private String telefone;
    private String site;
    private Long id;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String uf;

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {return cnpj;}

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
