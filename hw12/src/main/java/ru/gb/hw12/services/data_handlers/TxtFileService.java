package ru.gb.hw12.services.data_handlers;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service("txtWriter")
@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface TxtFileService extends DataService{
    @Override
    void writeData(@Header(FileHeaders.FILENAME) String filename, String data);
}
