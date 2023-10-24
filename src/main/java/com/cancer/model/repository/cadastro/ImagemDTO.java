package com.cancer.model.repository.cadastro;

public class ImagemDTO {
    private Long id;
    private String descricao;

    // Construtor vazio
    public ImagemDTO() {
    }

    // Construtor com parâmetros
    public ImagemDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
