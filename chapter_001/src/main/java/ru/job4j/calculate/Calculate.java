package ru.job4j.calculate;

/**
 * Объект класса {@code Calculate} выводит строку
 * в консоль.
 *
 * @author Александр Петренко (Lexer8@gmail.com)
 * @version 1.0
 */
public class Calculate {
	
	/**
	 * Точка входа в программу.
	 *
	 * @param args - аргументы из командной строки
	 * в виде массива объектов String.
	 */
	public static void main(String[] args) {
		System.out.println("We will not use 'Hello, World!'");
	}
	
	/**
	 * Method echo.
	 *
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}