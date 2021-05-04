package com.simple.demo.model;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Address {

    @NotBlank
    private final String logradouro;
    
    @NotBlank
    private final String numero;
    
    @NotBlank
    private final String complemento;

    @NotBlank
    private final String bairro;
    @NotBlank
    private final String cidade;
    @NotBlank
    private final String estado;
    @NotBlank
    private final String CEP;
    @NotBlank
    private final String cpf;


    public Address(@JsonProperty("logradouro") String logradouro,
                @JsonProperty("numero")  String numero,
                @JsonProperty("complemento")  String complemento,
                @JsonProperty("bairro")  String bairro,
                @JsonProperty("cidade")  String cidade,
                @JsonProperty("estado")  String estado,
                @JsonProperty("CEP")  String CEP,
                @JsonProperty("cpf") String cpf){
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
        this.cpf = cpf;
    }
public String getBairro() {
    return bairro;
}
public String getCidade() {
    return cidade;
}
public String getEstado() {
    return estado;
}
public String getLogradouro() {
    return logradouro;
}
public String getNumero() {
    return numero;
}
public String getComplemento() {
    return complemento;
}
public String getCEP() {
    return CEP;
}
public String getCPF() {
    return cpf;
}
}
