package ru.geekbrains.hometask1.program;

import ru.geekbrains.hometask1.lib.MapGenerator;
import ru.geekbrains.hometask1.lib.MapPrinter;
import ru.geekbrains.hometask1.lib.Point2D;
import ru.geekbrains.hometask1.lib.WaveAlgorythm;

public class Main {
    public static void main(String[] args) {

        var mg = new MapGenerator();

        System.out.println(
                new MapPrinter().mapColor(
                        mg.getMap())
        );

        var lee = new WaveAlgorythm(mg.getMap());
        lee.Colorize(new Point2D(13, 10));
        lee.putRoadToMap(lee.getRoad(new Point2D(5,8)));

        System.out.println(
                new MapPrinter().mapColor(
                        mg.getMap())
        );
    }

}
