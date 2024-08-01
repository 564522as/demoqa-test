package com.example.selenidedemo.appleinsider;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class CollectionTest {
    @Test
    public void openAllHref() {
        Selenide.open("https://ru.wikipedia.org/wiki/Java");
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        hrefs.forEach(x -> links.add(x.getAttribute("href")));

//        links.forEach(Selenide::open);

//        for (int i = 0; i < links.size(); i++) {
//            String listUrl = links.get(i);
//            Selenide.open(listUrl);
//            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//            Assertions.assertEquals(currentUrl, listUrl);
//        }

//        Random random = new Random();
//        while (links.size() > 0) {
//            int randomNumber = random.nextInt(links.size());
//            Selenide.open(links.get(randomNumber));
//            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
//        }

        List<Integer> linksLength = hrefs
                .asDynamicIterable()
                .stream()
                .map(x -> x.getAttribute("href").length())
                .collect(Collectors.toList());
        int y = 0;
    }
}
