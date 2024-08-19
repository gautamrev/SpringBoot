package com.gr;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "log_entries")
public class LogEntry {

    private static final Logger logger = LoggerFactory.getLogger(LogEntry.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    // Getters and setters

    public Long getId() {
        logger.debug("Getting ID: {}", id);
        return id;
    }

    public void setId(Long id) {
        logger.debug("Setting ID: {}", id);
        this.id = id;
    }

    public String getSerialNumber() {
        logger.debug("Getting Serial Number: {}", serialNumber);
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        logger.debug("Setting Serial Number: {}", serialNumber);
        this.serialNumber = serialNumber;
    }

    public String getCreatedBy() {
        logger.debug("Getting Created By: {}", createdBy);
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        logger.debug("Setting Created By: {}", createdBy);
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        logger.debug("Getting Created Time: {}", createdTime);
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        logger.debug("Setting Created Time: {}", createdTime);
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        logger.debug("Getting Updated By: {}", updatedBy);
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        logger.debug("Setting Updated By: {}", updatedBy);
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        logger.debug("Getting Updated Time: {}", updatedTime);
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        logger.debug("Setting Updated Time: {}", updatedTime);
        this.updatedTime = updatedTime;
    }
}
