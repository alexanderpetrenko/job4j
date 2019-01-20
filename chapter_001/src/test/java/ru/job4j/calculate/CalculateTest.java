package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class CalculateTest{
	
	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName(){
		String input = "Alexander Petrenko";
		String expect = "Echo, echo, echo : Alexander Petrenko";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}