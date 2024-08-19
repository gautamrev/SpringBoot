package com.gr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class LogEntryService {

    private static final Logger logger = LoggerFactory.getLogger(LogEntryService.class);

    @Autowired
    private LogEntryRepository logEntryRepository;

    public LogEntry createLogEntry(String serialNumber, String createdBy) {
        LogEntry logEntry = new LogEntry();
        logEntry.setSerialNumber(serialNumber);
        logEntry.setCreatedBy(createdBy);
        logEntry.setCreatedTime(LocalDateTime.now());
        logger.info("Creating LogEntry: {}", logEntry);
        LogEntry savedLogEntry = logEntryRepository.save(logEntry);
        logger.debug("Created LogEntry: {}", savedLogEntry);
        return savedLogEntry;
    }

    public LogEntry updateLogEntry(Long id, String updatedBy) {
        logger.info("Updating LogEntry with id: {}", id);
        LogEntry logEntry = logEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("LogEntry not found"));
        logEntry.setUpdatedBy(updatedBy);
        logEntry.setUpdatedTime(LocalDateTime.now());
        LogEntry updatedLogEntry = logEntryRepository.save(logEntry);
        logger.debug("Updated LogEntry: {}", updatedLogEntry);
        return updatedLogEntry;
    }
}
