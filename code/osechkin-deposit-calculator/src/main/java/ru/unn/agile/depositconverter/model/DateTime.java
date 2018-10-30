package ru.unn.agile.depositconverter.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy") {{
        setLenient(false);
    }};
    private Date dateTime;

    public DateTime() {
        this.dateTime = new Date();
    }

    public DateTime(final String date) throws ParseException {
        this.dateTime = formatter.parse(date);
    }

    public String convertToString() {
        return formatter.format(this.dateTime);
    }
}
