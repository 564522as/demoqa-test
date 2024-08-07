package com.example.selenidedemo.demoqa.api.bookStore;

import com.example.selenidedemo.demoqa.api.account.AccountUtil;
import com.example.selenidedemo.demoqa.api.model.AddListOfBooksDTO;
import com.example.selenidedemo.demoqa.api.model.Book;
import com.example.selenidedemo.demoqa.api.model.ISBN;
import com.example.selenidedemo.demoqa.api.model.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BookTests {
    private final String URL = "https://demoqa.com/BookStore/v1/";
    private UserData userData;
    private String token;
    @BeforeEach
    public void init() {
        userData = AccountUtil.registration();
        token = AccountUtil.generateToken(userData);
    }
    @Test
    public void testGetBooks() {
        List<Book> books =
                given()
                .get(URL + "Books")
                .then()
                .log().all()
                .extract().jsonPath().get("books");
        Assertions.assertTrue(books.size() > 0);
    }
    @Test
    public void testAddListOfBooks() {
        List<ISBN> collectionOfIsbns =
                BookUtil.getALlBooks().stream()
                .map(x -> new ISBN(x.getIsbn())).collect(Collectors.toList());

        AddListOfBooksDTO addListOfBooksDTO =
                new AddListOfBooksDTO(userData.getUserId(), collectionOfIsbns);
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(addListOfBooksDTO)
                .post(URL + "Books")
                .then()
                .log().all()
                .body("books.isbn", notNullValue());
    }
    @Test
    public void testDeleteBooks() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .delete(URL + "Books?UserId=" + userData.getUserId())
                .then()
                .log().all();
    }
    @Test
    public void testGetBook() {
        Book book = given()
                .contentType(ContentType.JSON)
                .get(URL + "Book?ISBN=" + BookUtil.getALlBooks().get(1).getIsbn())
                .then()
                .log().all()
                .extract().as(Book.class);
        Assertions.assertNotNull(book);
    }
    @Test
    public void testDeleteOneBook() {
        Map<String, String> bookData = new HashMap<>();
        bookData.put("isbn", BookUtil.getALlBooks().get(1).getIsbn());
        bookData.put("userId", userData.getUserId());
        given()
                .contentType(ContentType.JSON)
                .body(bookData)
                .header("Authorization", "Bearer " + token)
                .delete(URL + "Book")
                .then()
                .log().all();
    }
    @AfterEach
    public void deleteUserData() {
        AccountUtil.deleteUser(userData.getUserId(), token);
    }
}
