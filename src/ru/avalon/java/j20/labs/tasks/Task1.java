package ru.avalon.java.j20.labs.tasks;

import java.io.ByteArrayOutputStream;
import ru.avalon.java.j20.labs.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_binary_mode_output.txt");
        String text = read(input);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        try(InputStream stream = new FileInputStream(file); //Try с ресурсами позволяет произвести автоматическое закрытие объекта
                ByteArrayOutputStream memory = new ByteArrayOutputStream()){ //Сохраняет данные потока в виде массива байт в оперативной памяти
            byte[] buffer = new byte[10];
            int len;
            while ((len = stream.read(buffer)) != -1){ //Чтение потока в буффер
                memory.write(buffer, 0, len);
            }
            String result = memory.toString(); // Сохранение результата
            return result;
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        try(OutputStream stream = new FileOutputStream(file)){
            byte[] buffer = new byte[10];
            buffer = text.getBytes(); // Переводит текст в байты и передает их в буфер
            stream.write(buffer);
        }
    }
}
