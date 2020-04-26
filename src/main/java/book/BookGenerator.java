package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookGenerator {

    public static Faker faker = new Faker(Locale.ITALIAN);


    public static Book randomBook(){

        Book book = Book.builder()
                .isbn13(faker.code().isbn13(true))
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.values()))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().past(36500, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().numberBetween(10, 1000))
                .available(faker.bool().bool())
                .build();

        return book;
    }

}
