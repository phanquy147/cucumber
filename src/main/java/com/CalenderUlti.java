package com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalenderUlti{
    String input = "MM/DD/YYYY";

    public String convertToDatePickerFormat(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        Date convertDate = sdf.parse(date);
        sdf.applyPattern("dd MMMM,yyyy");
        return sdf.format(convertDate);
    }

    public String convertDate(String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date convertDate = sdf.parse(date);
        sdf.applyPattern("dd/MM/yyyy");
        return sdf.format(convertDate);
    }

}
