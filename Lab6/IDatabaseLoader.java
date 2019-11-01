package com.company;

import java.util.List;
import java.util.Scanner;

interface IDatabaseLoader<T extends Model> {
    List<T> load(Scanner fin);
}
