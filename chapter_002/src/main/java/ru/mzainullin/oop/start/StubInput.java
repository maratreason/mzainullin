package ru.mzainullin.oop.start;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * При каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     * @param question - вопрос
     * @return answers - ответ
     */
    public String ask(String question) {
        return this.answers[this.position++];
    }

    /**
     * Перегруженный метод ask.
     * @param question - первый параметр
     * @param range - второй параметр. диапазон
     * @return -1
     */
    public int ask(String question, int[] range) {
//        throw new UnsupportedOperationException("Unsupported operation");
        return Integer.valueOf(this.ask(question));
    }
}
