package com.robert.demo.service;

import com.robert.demo.entity.Document;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    Document getById(String id) throws IOException;

    List<Document> search(String query) throws IOException;
}
