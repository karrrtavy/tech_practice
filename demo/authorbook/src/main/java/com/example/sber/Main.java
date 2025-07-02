package com.example.sber;

// fourth task
class Author {
    private String aName;
    private String gender;
    private String email;

    public Author(String aName, String gender, String email) {
        this.aName = aName;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return aName;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String aName) {
        this.aName = aName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setMail(String email) {
        this.email = email;
    }


}

// не применяем явное наследование Author, но создаем Author объект в Book
class Book {
    private String name;
    private Author author;
    // можно объявить как String, но будет занимать больше памяти, проще добавить процесс валидации на длину, через преобразование int в String
    private int year;  

    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public Author getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Книга: " + name + " Автор: " + author.getName() + " Год: " + year;
    }

}

public class Main {
    public static void main(String[] args) {
        // fourth task
        System.out.println("Fourth task:");
        Author author = new Author("Федор Достоевский", "Male", "dostoevsky@mail.li");

        Book book = new Book("Бесы", author, 1871);

        System.out.println(book.toString());
    }
}