package com.example.address.client;

public interface JusoClient {

    JusoApiResponse find(int currentPage, int countPerPage, String keyword);
}
