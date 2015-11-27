package com.example.playground.monadic.parser.combinators;

import org.junit.Test;

import static com.example.playground.monadic.parser.combinators.Parsed.parsedList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OrParserTest {
    @Test
    public void shouldReturnResultOfSecondParserIfFirstOneFailed() {
        Parser parser = Parsers.or(Parsers.lower(), Parsers.upper());

        assertThat(parser.parse("world"), is(equalTo(parsedList("w", "orld"))));
        assertThat(parser.parse("World"), is(equalTo(parsedList("W", "orld"))));
        assertThat(parser.parse(""), is(equalTo(parsedList())));
    }
}