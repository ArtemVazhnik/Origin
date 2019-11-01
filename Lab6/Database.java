package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

class Database<T> {
    private List<T> data;
    private IDatabaseLoader loader;
    private Supplier<T> sup;
    public Database(Supplier<T> sup, IDatabaseLoader loader) {
        this.sup = sup;
        this.loader = loader;
    }

    public void load(Scanner fin) {
        data = loader.load(fin);
    }

    public void sort(String columnField) throws NoSuchFieldException, IllegalAccessException {
        T compared = sup.get();
        Field field = compared.getClass().getDeclaredField(columnField);
        Comparator<T> comparator = (o1, o2) -> {
            try {
                Field fieldO1 = o1.getClass().getDeclaredField(columnField);
                Field fieldO2 = o2.getClass().getDeclaredField(columnField);
                String data1 = (String) fieldO1.get(o1);
                String data2 = (String) fieldO2.get(o2);
                return data1.compareTo(data2);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        };
        data.sort(comparator);

    }

    public int writeToFile(FileWriter fout) throws IOException {
        int usersAmount = 0;
        for (T temp: data) {
            fout.append(temp.toString() + "\n");
            usersAmount++;
        }
        return usersAmount;
    }

    public List<T> getData() {
        return data;
    }
}
