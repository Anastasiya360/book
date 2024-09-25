package com.example.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Schema(description = "Уникальный идентификатор записи", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer id;

    @Schema(description = "Наименование книги", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Автор книги", requiredMode = Schema.RequiredMode.REQUIRED)
    private String author;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Цена книги", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double price;
}
