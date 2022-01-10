package com.company.objects;

public class books {
    private String bookName;
    private String bookIBSN;
    private String bookAuthor;
    private String bookGenre;

    public books(String bookName, String bookIBSN, String bookAuthor, String bookGenre) {
        this.bookName = bookName;
        this.bookIBSN = bookIBSN;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIBSN() {
        return bookIBSN;
    }

    public void setBookIBSN(String bookIBSN) {
        this.bookIBSN = bookIBSN;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
