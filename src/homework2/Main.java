package homework2;

//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
public class Main {
    public static void main(String[] args) {

        String[][] str = {
                {"7", "2", "18", "23"},
                {"3", "22", "4", "17"},
                {"1", "7", "111", "13"},
                {"4", "8", "4", "15"}
        };
        try {
            System.out.println(workWithMassive(str));
        } catch (NewArraySizeException | NewArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int workWithMassive(String[][] array) throws NewArraySizeException, NewArrayDataException {

        int sum = 0;

        if (array.length != 4) {
            throw new NewArraySizeException("В массиве не 4 строки. Количество строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != 4) {
                    throw new NewArraySizeException("В строке " + i + " не 4 элемента. Количество элементов в строке: " + array[i].length);
                }
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new NewArrayDataException("Элемент массива " + i + "," + j + " не является числом");
                }
            }
        }

        return sum;
    }
}

class NewArraySizeException extends Exception {
    public NewArraySizeException(String message) {
        super(message);
    }
}

class NewArrayDataException extends Exception {
    public NewArrayDataException(String string) {
        super(string);
    }
}