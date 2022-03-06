package ru.netology.manager;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repo.Repository;

public class Manager {
    private final Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        this.repo.save(product);
    }
    public Product[] searchBy(String text) {
        Product[] products = this.repo.findAll();
        Product[] result = new Product[0];
        for (Product product : products) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = product;
                result = temp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains((search))) {
            return true;
        }
        ;
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            if (tShirt.getBrand().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
