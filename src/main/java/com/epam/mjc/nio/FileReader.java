package com.epam.mjc.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = file.getAbsoluteFile().toPath();
        StringBuilder stringBuilder = new StringBuilder();

        try(InputStream input = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] values = new String[4];
        int j = 0;
        for (String i : stringBuilder.toString().split("\n")) {
            int start = i.indexOf(": ") + 1;
            String value = i.substring(start).trim();
            values[j] = value;
            j++;
        }
        String name = values[0];
        Integer age = Integer.valueOf(values[1]);
        String email = values[2];
        Long phone = Long.valueOf(values[3]);

        return new Profile(name,age,email,phone);

    }
}
