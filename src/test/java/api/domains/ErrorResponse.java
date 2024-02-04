package api.domains;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse() {

    }

    public ErrorResponse(String timestamp, int status, String error, String message, String path) {
        this.timestamp = dateFormat(timestamp);
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;

    }

    private static String dateFormat(String date) {
        // Splitting the date into date and time parts
        String[] parts = date.split("T");

        // Extracting the hour part
        String[] timeParts = parts[1].split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if (hour > 12) {
            hour %= 12;
        }
        // Ensuring the hour part is in two-digit format
        String formattedHour = String.format("%02d", hour);

        // Constructing the formatted date
        return parts[0] + "T" + formattedHour + ":" + timeParts[1] + ":" + timeParts[2];
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = dateFormat(timestamp);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
