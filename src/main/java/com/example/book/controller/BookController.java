package com.example.book.controller;

import com.example.book.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Операции с книгами")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApiResponse(responseCode = "" + HttpServletResponse.SC_INTERNAL_SERVER_ERROR, description = "Внутренняя ошибка сервера")
public interface BookController {

    @Operation(summary = "Получение списка книг",
            description = "Получение списка книг")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_OK, description = "Запрос выполнен успешно",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Book.class)))),
    })
    List<Book> getBooks();

    @Operation(summary = "Получение книги по id",
            description = "Получение книги по id")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_OK, description = "Запрос выполнен успешно",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_BAD_REQUEST, description = "id не передан"),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_NOT_FOUND, description = "Книга не найдена"),
    })
    Book getBookById(@PathVariable Integer id);

    @Operation(summary = "Создание книги",
            description = "Создание книги")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_OK, description = "Запрос выполнен успешно",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_BAD_REQUEST, description = """
                    * Заголовок не передан
                    * Цена не передана
                    * Автор не передан
                    """),
    })
    Book create(
            @Parameter(description = "Модель книги") @RequestBody Book book);

    @Operation(summary = "Обновление книги",
            description = "Обновление книги по id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_OK, description = "Запрос выполнен успешно",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_BAD_REQUEST, description = "id не передан"),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_NOT_FOUND, description = "Книга не найдена"),
    })
    Book update(
            @PathVariable Integer id,
            @Parameter(description = "Модель книги") @RequestBody Book book);

    @Operation(summary = "Удаление книги",
            description = "Удаление книги по id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_OK, description = "Запрос выполнен успешно"),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_BAD_REQUEST, description = "id не передан"),
            @ApiResponse(responseCode = "" + HttpServletResponse.SC_NOT_FOUND, description = "Книга не найдена"),
    })
    void deleteById(
            @PathVariable Integer id);
}
