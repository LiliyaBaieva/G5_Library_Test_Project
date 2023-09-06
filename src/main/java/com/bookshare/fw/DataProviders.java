package com.bookshare.fw;

import com.bookshare.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviders {

  @DataProvider
  public Iterator<Object[]> addUserFromCsvFile() throws IOException{
    List<Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File(
        "src/test/resources/user.csv"
    )));

    String line = reader.readLine();

    while(line != null){
      String[] split = line.split(",");
      list.add(new Object[]{new User()
                                .setEmail(split[0])
                                .setPassword(split[1])
                                .setConfirmPassword(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  public Iterator<Object[]> addUserFromCsvFileNegative() throws IOException{
    List<Object[]> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(new File(
        "src/test/resources/user_negative.csv" //TODO
    )));

    String line = reader.readLine();

    while(line != null){
      String[] split = line.split(",");
      list.add(new Object[]{new User()
                                .setEmail(split[0])
                                .setPassword(split[1])
                                .setConfirmPassword(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }



}
