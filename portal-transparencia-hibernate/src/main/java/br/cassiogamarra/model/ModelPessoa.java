package br.cassiogamarra.model;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA")
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

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "CPF")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "NOME")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "SIGLA")
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Column(name = "DESCRICAO_FUNCAO")
    public String getDescricaoFuncao() {
        return descricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }

    @Column(name = "NIVEL_FUNCAO")
    public String getNivelFuncao() {
        return nivelFuncao;
    }

    public void setNivelFuncao(String nivelFuncao) {
        this.nivelFuncao = nivelFuncao;
    }

    @Column(name = "NOME_ORGAO")
    public String getNomeOrgao() {
        return nomeOrgao;
    }

    public void setNomeOrgao(String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }

    @Column(name = "DT_INI_EXERCICIO")
    public String getDtIniExercicio() {
        return dtIniExercicio;
    }

    public void setDtIniExercicio(String dtIniExercicio) {
        this.dtIniExercicio = dtIniExercicio;
    }

    @Column(name = "DT_FIM_EXERCICIO")
    public String getDtFimExercicio() {
        return dtFimExercicio;
    }

    public void setDtFimExercicio(String dtFimExercicio) {
        this.dtFimExercicio = dtFimExercicio;
    }

    @Column(name = "DT_FIM_CARENCIA")
    public String getDtFimCarencia() {
        return dtFimCarencia;
    }

    public void setDtFimCarencia(String dtFimCarencia) {
        this.dtFimCarencia = dtFimCarencia;
    }
}
