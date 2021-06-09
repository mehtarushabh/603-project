grammar Grammar;

//Tokens

INTEGER: [0-9]+;

ADD:                    '+';
SUBTRACT:               '-';
MULTIPLY:               '*';
DIVIDE:                 '/';

EXPONENT:               '^';

SINE:                   '@';
COSINE:                 '#';
TANGENT:                '$';
LOGARITHM:              '!';

WHITESPACE: [ \r\n\t] -> skip;


//Production Rules

start: expression;

expression
   : INTEGER                                                                           # Integer
   | '(' inner = expression ')'                                                        # Parentheses
   | left = expression operation = EXPONENT right = expression                         # Exponent
   | operation = (SINE | COSINE | TANGENT | LOGARITHM) right = expression              # ScientificFunction
   | left = expression operation = (MULTIPLY | DIVIDE) right = expression              # MultiplicationOrDivision
   | left = expression operation = (ADD | SUBTRACT) right = expression                 # AdditionOrSubtraction
   ;