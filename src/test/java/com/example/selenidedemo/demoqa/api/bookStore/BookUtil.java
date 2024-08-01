package com.example.selenidedemo.demoqa.api.bookStore;

import com.example.selenidedemo.demoqa.api.model.Book;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookUtil {
    private static final String URL = "https://demoqa.com/BookStore/v1/";
    public static List<Book> getALlBooks() {
        List<Book> books =
                given()
                        .get(URL + "Books")
                        .then()
                        .log().all()
                        .extract().jsonPath().getList("books", Book.class);
        return books;
    }
}
