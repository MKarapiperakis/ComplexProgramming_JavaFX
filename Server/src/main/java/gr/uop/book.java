package gr.uop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class book {
    String sum;
    String ak;
    String date;

    public book(String sum,String ak, String date)
    {
        this.sum = sum;
        this.ak = ak;
        this.date = date;
    }

    public String sum_print()
    {
        return sum;
    }

    public String ak_print()
    {
        return ak;
    }

    public String date_print()
    {
        return date;
    }

    
}
