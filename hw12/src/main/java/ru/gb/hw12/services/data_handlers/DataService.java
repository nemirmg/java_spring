package ru.gb.hw12.services.data_handlers;


import org.springframework.stereotype.Service;

@Service
public interface DataService {
    void writeData(String filename, String data);
}
