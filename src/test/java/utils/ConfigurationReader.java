package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // Статическая переменная для хранения свойств конфигурационного файла
    private static Properties properties;

    static {
        try {
            // Загрузка конфигурационного файла
            FileInputStream file = new FileInputStream("src/test/resources/config/configuration.properties");
            // Создаем объект Properties для хранения пар "ключ-значение"
            properties = new Properties();
            // Загружаем данные из файла в объект properties
            properties.load(file);
        } catch (IOException e) {
            // Если файл не удается открыть или загрузить, выводим ошибку
            e.printStackTrace();
        }
    }

    // Метод для получения значения из конфигурационного файла
    public static String get(String key) {
        return properties.getProperty(key);
    }
}