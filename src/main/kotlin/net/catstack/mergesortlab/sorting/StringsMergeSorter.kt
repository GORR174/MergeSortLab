package net.catstack.mergesortlab.sorting

/**
 * Класс, представляющий сортировщик списка строк
 */
class StringsMergeSorter : ISorter<String> {
    var operationsCount = 0

    /**
     * Метод для вызова сортировки. Необходим для обнуления счётчика операций
     * @param list - исходный массив
     * @return сортированный массив
     */
    override fun sort(list: List<String>): List<String> {
        operationsCount = 0

        return startSort(list)
    }

    /**
     * Сортировка массива слиянием
     * @param list - исходный массив
     * @return сортированный массив
     */
    private fun startSort(list: List<String>): List<String> {
        if (list.size <= 1) {
            return list
        }

        val middle = list.size / 2
        val left = list.subList(0, middle);
        val right = list.subList(middle, list.size);

        return merge(startSort(left), startSort(right))
    }

    /**
     * Слияние двух списков
     * @param left - первый список на слияние
     * @param right - второй список на слияние
     * @return новый список, полученный путём слияния по возрастанию переданных списков
     */
    private fun merge(left: List<String>, right: List<String>): List<String>  {
        var indexLeft = 0
        var indexRight = 0
        val newList = arrayListOf<String>()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                addElementToList(left[indexLeft], newList)
                indexLeft++
            } else {
                addElementToList(right[indexRight], newList)
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            addElementToList(left[indexLeft], newList)
            indexLeft++
        }

        while (indexRight < right.size) {
            addElementToList(right[indexRight], newList)
            indexRight++
        }

        return newList
    }

    /**
     * Добавление элемента в список. Необходим для увеличения счётчика при добавлении элемента
     * @param element - элемент, который необходимо добавить в список
     * @param list - список, в который необходимо добавить элемент
     */
    private fun addElementToList(element: String, list: ArrayList<String>) {
        operationsCount++
        list.add(element)
    }
}