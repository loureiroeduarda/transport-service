package com.github.loureiroeduarda;

import com.github.loureiroeduarda.menu.Menu;
import com.github.loureiroeduarda.model.LargeTruck;
import com.github.loureiroeduarda.model.MediumTruck;
import com.github.loureiroeduarda.model.SmallTruck;
import com.github.loureiroeduarda.model.Truck;
import com.github.loureiroeduarda.repository.RepositoryTruck;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.menu();

    }
}