public class Main {
    public static void main(String[] args) {
        String[][] strings = { { "1", "jdn", "3", "hdhj" }, { "fjhfd", "jgddn", "ddgbjc", "hdhgj" },
                { "1", "2", "3", "4" }, { "fjd", "5", "5", "5" } };
        try {
            int sum = stringsToInts(strings);
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static int stringsToInts(String[][] strings) throws MyArraySizeException, MyArrayDataException {

        if ((strings.length != 4) || (strings[0].length != 4)) {
            throw new MyArraySizeException("Размер массива неверный");
        }
        // int[][] ints = new int[4][4];
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                try {
                    // ints[i][j] = Integer.parseInt(strings[i][j]);
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Не удалось выполнить преобразование у элемента в строке " + i + " стобце " + j);

                }
            }
        }
        return sum;
    }
}
