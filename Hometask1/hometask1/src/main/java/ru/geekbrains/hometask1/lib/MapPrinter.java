package ru.geekbrains.hometask1.lib;

public class MapPrinter {

    public MapPrinter() {
    }

    /**
     * Метод выводит на экран карту в цифровом виде
     *
     * @param map - массив точек (карта в цифровом виде)
     * @return - формируемое отображение в виде строки из цифр
     */
    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }

        sb.append("\n");
        return sb.toString();
    }

    /**
     * Метод вывод на экран карту в раскрашенном виде
     *
     * @param map - массив точек (карта в цифровом виде)
     * @return - формируемое отображение в виде спецсимволов/псевдографики
     */
    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("\u2591"); //sb.append("░");
                        break;
                    case -1:
                        sb.append("\u2592"); //sb.append("▓");
                        break;
                    case -2:
                        sb.append("К");
                        break;
                    case -3:
                        sb.append("E");
                        break;
                    case -4:
                        sb.append(".");
                        break;
                    default:
                        sb.append("\u2591"); // sb.append("░");
                        break;
                }
            }
            sb.append("\n");
        }

        sb.append("\n");
        return sb.toString();
    }

}
