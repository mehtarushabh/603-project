grammar Grammar;

/*
 * Tokens
 */

INTEGER: [0-9];

ADD:        '+';
SUBTRACT:   '-';
MULTIPLY:   '*';
DIVIDE:     '/';
EXPONENT:   '^';
SINE:       '%';
COSINE:     '$';
TANGENT:    '@';

WHITESPACE: [ \r\n\t] -> skip;


/*
 * Production Rules
 */

start : expression;

expression
   : INTEGER                                                                    # Integer
   | '(' inner = expression ')'                                                 # Parentheses
   | left = expression operator = EXPONENT right = expression                   # Exponent
   | left = expression operator = (MULTIPLY | DIVIDE) right = expression        # MultiplicationOrDivision
   | operator = (SINE | COSINE | TANGENT) right = expression                    # TrigonometricFunctions
   | left = expression operator = (ADD | SUBTRACT) right = expression           # AdditionOrSubtraction
   ;