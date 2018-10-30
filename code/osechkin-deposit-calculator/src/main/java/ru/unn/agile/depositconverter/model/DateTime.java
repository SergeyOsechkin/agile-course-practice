package ru.unn.agile.depositconverter.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy") {{
        setLenient(false);
    }};
    private Date date;

    public DateTime() {
        this.date = new Date();
    }

    public DateTime(final String date) throws ParseException {
        this.date = FORMATTER.parse(date);
    }

    public String convertToString() {
        return FORMATTER.format(this.date);
    }
}
