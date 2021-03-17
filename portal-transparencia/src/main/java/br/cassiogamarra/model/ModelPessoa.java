package br.cassiogamarra.model;

public class ModelPessoa {
    public ModelPessoa() {
    }

    private int id;
    private String cpf;
    private String nome;
    private String sigla;
    private String descricaoFuncao;
    private String nivelFuncao;
    private String nomeOrgao;
    private String dtIniExercicio;
    private String dtFimExercicio;
    private String dtFimCarencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricaoFuncao() {
        return descricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }

    public String getNivelFuncao() {
        return nivelFuncao;
    }

    public void setNivelFuncao(String nivelFuncao) {
        this.nivelFuncao = nivelFuncao;
    }

    public String getNomeOrgao() {
        return nomeOrgao;
    }

    public void setNomeOrgao(String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }

    public String getDtIniExercicio() {
        return dtIniExercicio;
    }

    public void setDtIniExercicio(String dtIniExercicio) {
        this.dtIniExercicio = dtIniExercicio;
    }

    public String getDtFimExercicio() {
        return dtFimExercicio;
    }

    public void setDtFimExercicio(String dtFimExercicio) {
        this.dtFimExercicio = dtFimExercicio;
    }

    public String getDtFimCarencia() {
        return dtFimCarencia;
    }

    public void setDtFimCarencia(String dtFimCarencia) {
        this.dtFimCarencia = dtFimCarencia;
    }
}
