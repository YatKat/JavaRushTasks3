# JavaRushTasks3

CrUD для таблицы внутри файла.

Программа считывает с консоли имя файла для операций CrUD.
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов.
productName - название товара, 30 chars (60 bytes).
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, 
найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины.
