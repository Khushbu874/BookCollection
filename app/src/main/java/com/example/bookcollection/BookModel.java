package com.example.bookcollection;

public class BookModel {
    private String title;
    private String pdfUrl;

    public BookModel(String title, String pdfUrl) {
        this.title = title;
        this.pdfUrl = pdfUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }
}
