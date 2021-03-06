package org.motechproject.eventlogging.loggers.impl;

import org.motechproject.event.MotechEvent;
import org.motechproject.eventlogging.converter.impl.DefaultFileToLogConverter;
import org.motechproject.eventlogging.matchers.LoggableEvent;
import org.motechproject.eventlogging.loggers.EventLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the {@link EventLogger} class.
 * The <code>FileEventLogger</code> class is responsible for logging
 * event records to the file.
 */
public class FileEventLogger extends EventLogger {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<File> loggingFiles;

    private DefaultFileToLogConverter eventConverter;

    public FileEventLogger(DefaultFileToLogConverter eventConverter) {
        this.eventConverter = eventConverter;
    }

    public FileEventLogger(List<LoggableEvent> loggableEvents, List<File> loggingFiles,
                           DefaultFileToLogConverter eventConverter) {
        addLoggableEvents(loggableEvents);
        if (loggingFiles == null) {
            this.loggingFiles = Collections.emptyList();
        } else {
            this.loggingFiles = loggingFiles;
        }
        this.eventConverter = eventConverter;
    }

    @Override
    public void log(MotechEvent eventToLog) {
        for (LoggableEvent loggableEvent : getLoggableEvents()) {
            if (loggableEvent.isLoggableEvent(eventToLog)) {
                if (eventConverter != null) {
                    String logString = eventConverter.convertToLog(eventToLog);
                    log(logString);
                } else {
                    return;
                }
            }
        }
    }

    protected void log(String informationToLog) {
        for (File fileToLogTo : loggingFiles) {
            try {
                fileToLogTo.createNewFile();
            } catch (IOException e) {
                logger.warn("Unable to create file: " + fileToLogTo.getAbsolutePath());
            }
            if (fileToLogTo.canWrite()) {
                writeToFile(informationToLog, fileToLogTo);
            } else {
                logger.warn("Unable to write to: " + fileToLogTo.getAbsolutePath());
            }
        }

    }

    private synchronized void writeToFile(String eventToLog, File fileToLogTo) {

        try (FileWriter fileStream = new FileWriter(fileToLogTo, true);
             BufferedWriter fileWriter = new BufferedWriter(fileStream)) {
            fileWriter.write((eventToLog));
            fileWriter.newLine();
            fileWriter.flush();
        } catch (IOException e) {
            logger.warn("Error when trying to log to file " + fileToLogTo + ": " + e.getMessage());
        }
    }
}
