package ru.netology.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Product firstProduct = new Product(1, "Блуза_ice", 1500);
    Product secondProduct = new Product(2, "Брюки_размер_7", 500);
    Book thirdProduct = new Book(3, "Шьем_брюки_7_урок", 101, "Иванов");
    Book fourthProduct = new Book(4, "Дела_не_ice", 500, "Петров");
    TShirt fifthProduct = new TShirt(5, "Футботка_женск", 1500, "Красное", "Синий", "XL");
    TShirt sixthProduct = new TShirt(6, "Поло", 2700, "Красное", "Четный", "XS");
    Repository repo = new Repository();

    @BeforeEach
    void setDataProducts() {
        repo.save(firstProduct);
        repo.save(secondProduct);
        repo.save(thirdProduct);
        repo.save(fourthProduct);
        repo.save(fifthProduct);
        repo.save(sixthProduct);
    }

    @Test
    public void CheckForExistingId() {
        repo.removeById(5);
        Product[] expected = {firstProduct, secondProduct, thirdProduct, fourthProduct, sixthProduct};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void FirstCheckForNotExistingId() {
        Assertions.assertThrows(NotFoundException.class, ()->{repo.removeById(15);});
    }
}