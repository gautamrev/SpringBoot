package com.gr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/log")
public class LogEntryController {

    private static final Logger logger = LoggerFactory.getLogger(LogEntryController.class);

    @Autowired
    private LogEntryService logEntryService;

    @PostMapping("/create")
    public LogEntry createLogEntry(@RequestParam String serialNumber, @RequestParam String createdBy) {
        logger.info("Creating LogEntry with serialNumber: {} and createdBy: {}", serialNumber, createdBy);
        LogEntry logEntry = logEntryService.createLogEntry(serialNumber, createdBy);
        logger.debug("Created LogEntry: {}", logEntry);
        return logEntry;
    }

    @PutMapping("/update/{id}")
    public LogEntry updateLogEntry(@PathVariable Long id, @RequestParam String updatedBy) {
        logger.info("Updating LogEntry with id: {} by updatedBy: {}", id, updatedBy);
        LogEntry logEntry = logEntryService.updateLogEntry(id, updatedBy);
        logger.debug("Updated LogEntry: {}", logEntry);
        return logEntry;
    }
}
