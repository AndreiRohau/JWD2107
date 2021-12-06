package com.jwd.classloader;

public class MainA {
    ClassLoader classLoader = null; // abstrac, but ready to use
    {
        try {
            // check this method
            classLoader.loadClass("class.name");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Все процессы рассматривать как последовательные

    /*
    Bootstrap – базовый загрузчик, также называется Primordial ClassLoader.
    загружает стандартные классы JDK из архива rt.jar

    Extension ClassLoader – загрузчик расширений.
    загружает классы расширений, которые по умолчанию находятся в каталоге jre/lib/ext, но могут быть заданы системным свойством java.ext.dirs

    System ClassLoader – системный загрузчик.
    загружает классы приложения, определенные в переменной среды окружения CLASSPATH
     */

    /*
    1 - загрузка байт-кода из ресурсов
    2 - связывание (или линковка) :
      a - - Verification
      b - - Preparation
      c - - Resolution
    3 - инициализация полученного объекта
     */
}
