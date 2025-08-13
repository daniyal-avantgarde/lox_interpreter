public enum TokenType {
    // all the token types a lexeme might be categorised into

    // single character tokens
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, 
    PLUS, MINUS, SLASH, STAR, SEMICOLON, COMMA, DOT,
    
    // single or double character tokens
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    // literal tokens
    IDENTIFIER, STRING, NUMBER,

    // keywords
    AND, OR, 
    CLASS, FUNCTION, VARIABLE,
    THIS, SUPER,
    TRUE, FALSE, NIL,
    IF, ELSE, WHILE, FOR,
    PRINT, RETURN,

    //
    EOF

}
