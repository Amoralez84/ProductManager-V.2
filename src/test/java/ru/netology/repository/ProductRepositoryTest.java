package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.domain.Book;
import ru.netology.repository.domain.NotFoundException;
import ru.netology.repository.domain.Product;
import ru.netology.repository.domain.TShirt;
import ru.netology.repository.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Цифровая крепость", 339, "Дэн Браун", 448, 2017);
    private Book book2 = new Book(2, "Тестирование dot com", 1120, "Роман Савин", 312, 2017);
    private Book book3 = new Book(3, "Tom Clancy's The Division 2. Фальшивый рассвет", 352, "Алекс Ирвин", 488, 2019);
    private Product tShirt1 = new TShirt(4, "Samurai", 990, "White", "L");
    private Product tShirt2 = new TShirt(5, "GitHub Fork Place", 1590, "Black", "L");
    private Product tShirt3 = new TShirt(6, "NASA", 1190, "Black", "L");

    @BeforeEach
    void prepare() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tShirt1);
        repository.save(tShirt2);
        repository.save(tShirt3);
    }

    @Test
    public void shouldRemoveById() {

        repository.removeById(3);

        Product[] expected = new Product[]{book1, book2, tShirt1, tShirt2, tShirt3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNull() {

        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }
}