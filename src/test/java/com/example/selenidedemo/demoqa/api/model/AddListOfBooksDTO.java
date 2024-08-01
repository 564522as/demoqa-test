package com.example.selenidedemo.demoqa.api.model;

import java.util.List;

public class AddListOfBooksDTO {
    private String userId;
    private List<ISBN> collectionOfIsbns;

    public AddListOfBooksDTO(String userId, List<ISBN> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public List<ISBN> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCollectionOfIsbns(List<ISBN> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
