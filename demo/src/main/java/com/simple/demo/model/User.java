package com.simple.demo.model;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {

    @NotBlank
    private final String nome;

    @NotBlank
    private final String email;
    
    @NotBlank
    private final String CPF;
    
    @NotBlank
    private final String birthdate;

    public User(@JsonProperty("nome") String nome,
                @JsonProperty("email") String email,
                @JsonProperty("cpf")  String cpf,
                @JsonProperty("birthdate")  String birthdate){
        this.nome = nome;
        this.CPF = cpf;
        this.birthdate = birthdate;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

}
