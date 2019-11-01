package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

class CSVDatabaseLoader<T extends Model> implements IDatabaseLoader<T> {
    private Supplier<T> sup;
    public CSVDatabaseLoader(Supplier<T> sup) {
        this.sup = sup;
    }
    @Override
    public List<T> load(Scanner fin) {
        ArrayList<T> databaseList = new ArrayList<>();
        fin.nextLine();
        while (fin.hasNextLine()) {
            String line = fin.nextLine();
            T model = sup.get();
            model.setData(line.split(";"));
            databaseList.add(model);
        }
        return databaseList;
   }

}
