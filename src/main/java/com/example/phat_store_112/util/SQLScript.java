package com.example.phat_store_112.util;

import com.example.phat_store_112.model.entities.itemAttributes.Color;
import com.example.phat_store_112.model.entities.itemAttributes.Size;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class SQLScript {
    private static final String itemsFile = "items.txt";
    final static StringBuilder sb = new StringBuilder(
            "INSERT INTO items_t (model, amount, size, color, brand_id, category_id)\nVALUES ");
    final static Random r = new Random();

    public static void main(String[] args) throws IOException {
        Files.lines(Path.of(itemsFile)).forEach(line -> addItem(line));
        sb.append(";");
        System.out.println(sb);
    }

    private static void addItem(String line) {
        line = line.substring(1, line.length() - 2);
        String[] lineArr = line.split(", ");
        List<String> sizes = getSizes(Integer.parseInt(lineArr[0]));

        sb.append("('")
                .append(lineArr[1])
                .append("', ")
                .append(r.nextInt(0, 20))
                .append(", '")
                .append(sizes.get(r.nextInt(0, sizes.size())))
                .append("', '")
                .append(Color.values()[r.nextInt(0, Color.values().length)])
                .append("', ")
                .append(getBrandId(Integer.parseInt(lineArr[0])))
                .append(", ")
                .append(getCategoryId(Integer.parseInt(lineArr[0])))
                .append("),\n");
    }

    private static int getCategoryId(int id) {
        if (id < 16) return 1;
        if (id > 30) return 3;
        return 2;
    }

    private static int getBrandId(int id) {
        if (id < 16) return 1;
        if (id > 30) return 3;
        return 2;
    }

    private static List<String> getSizes(int id) {
        if (id < 16) return Size.values()[0].getSizes();
        if (id > 30) return Size.values()[2].getSizes();
        return Size.values()[1].getSizes();
    }

}
