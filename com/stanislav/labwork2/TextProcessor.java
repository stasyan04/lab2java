package com.stanislav.labwork2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {

    public static void main(String[] args) {
        try {
            execute();
        } catch (Exception e) {
            System.err.println("Виникла помилка під час виконання програми: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void execute() {
        long studentNumber = 13879022;

        int C3 = (int) (studentNumber % 3);
        int C17 = (int) (studentNumber % 17);

        System.out.println("C3 = " + C3);
        System.out.println("C17 = " + C17);

        String variableType = getVariableType(C3);
        if (variableType == null) {
            throw new IllegalArgumentException("Недійсний код C3: " + C3);
        }

        System.out.println("Тип текстових змінних: " + variableType);

        String action = getAction(C17);
        if (action == null) {
            throw new IllegalArgumentException("Недійсний код C17: " + C17);
        }

        System.out.println("Дія з текстом: " + action);

        StringBuffer text = new StringBuffer("Це перше речення. Друге речення має більше слів. А це третє речення.");

        System.out.println("Заданий текст:");
        System.out.println(text.toString());

        performAction(C17, text);
    }

    private static String getVariableType(int C3) {
        switch (C3) {
            case 0:
                return "StringBuilder";
            case 1:
                return "String";
            case 2:
                return "StringBuffer";
            default:
                return null;
        }
    }

    private static String getAction(int C17) {
        switch (C17) {
            case 0:
                return "Знайти найбільшу кількість речень, в яких є однакові слова.";
            case 1:
                return "Вивести всі речення заданого тексту в порядку зростання кількості слів у них.";
            case 2:
                return "Знайти таке слово в першому реченні, якого немає в жодному з наступних.";
            case 3:
                return "В усіх питальних реченнях заданого тексту знайти та надрукувати без повторень слова заданої довжини.";
            case 4:
                return "В кожному реченні заданого тексту змінити місцями перше та останнє слово, не змінивши довжини речення.";
            case 5:
                return "Надрукувати слова без повторень заданого тексту в алфавітному порядку за першою літерою.";
            case 6:
                return "Відсортувати слова заданого тексту за зростанням кількості голосних літер.";
            case 7:
                return "Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.";
            case 8:
                return "Відсортувати слова заданого тексту за зростанням кількості в них заданої літери.";
            case 9:
                return "Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.";
            case 10:
                return "З кожного речення заданого тексту видалити підрядок найбільшої довжини, що починається та закінчується заданими літерами.";
            case 11:
                return "Із заданого тексту видалити всі слова визначеної довжини, що починаються з приголосної літери.";
            case 12:
                return "Відсортувати слова заданого тексту за кількістю входжень визначеного символу в них.";
            case 13:
                return "В заданому тексті знайти підрядок максимальної довжини, що є паліндромом, тобто читається однаково зліва на право та справа на ліво.";
            case 14:
                return "В кожному слові заданого тексту, видалити всі наступні входження першої літери цього слова.";
            case 15:
                return "В заданому тексті замінити слова заданої довжини визначеним рядком.";
            case 16:
                return "В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.";
            default:
                return null;
        }
    }

    /*
    Не дуже зрозумів всю умову, але сподіваюсь 17 методів
    не треба було робити, але перед цим функціонал реалізовано
    для всіх варіантів (треба лише змінити studentNumber). Тож
    будь-хто може додати дію по своєму варіанту і це буде працювати
     */
    private static void performAction(int C17, StringBuffer text) {
        switch (C17) {
            case 1:
                printSentencesByWordCount(text);
                break;
            default:
                throw new IllegalArgumentException("Дія для C17 = " + C17 + " не реалізована.");
        }
    }

    private static void printSentencesByWordCount(StringBuffer text) {
        String[] sentencesArray = text.toString().split("(?<=[.!?])\\s*");
        List<StringBuffer> sentences = new ArrayList<>();
        for (String sentence : sentencesArray) {
            sentences.add(new StringBuffer(sentence));
        }

        sentences.sort(Comparator.comparingInt(TextProcessor::wordCount));

        System.out.println("Речення в порядку зростання кількості слів:");
        for (StringBuffer sentence : sentences) {
            System.out.println(sentence.toString());
        }
    }

    private static int wordCount(StringBuffer sentence) {
        String[] words = sentence.toString().trim().split("\\s+");
        return words.length;
    }
}