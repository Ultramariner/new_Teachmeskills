package com.tms.lesson34;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import java.io.*;

@SpringBootApplication
public class Lesson34Application {

    private String path;
    private static String filepath;

    public Lesson34Application() {
        setFilepath(path);
    }

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Lesson34Application.class, args);
        File file = new File(filepath);
        BufferedReader reader =new BufferedReader(new FileReader(file));
        int value = Integer.parseInt(reader.readLine());
        value++;
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(String.valueOf(value));
        reader.close();
        writer.close();
    }

    @Value("${file.path}")     //Почему без этого @Value nullpointer, а без аннотации над полем нет?
    public void setFilepath(String path) {    //как правильно @Value в static методах использовать?
        this.filepath = path;
    }
}
