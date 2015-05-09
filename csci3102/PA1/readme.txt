To run the program PostFixCalc, navigate to the folder containing PostFixCalc.java
using the command-line. Run javac on PostFixCalc.java and once compiled, run the program
by using the java command, the name of the program without the .java extension, and
the expression you wish to evaluate in quotes. Valid input accepted can only contain
the digits 0-9 and the operators ^, *, /, +, and - (both subtraction and unary).
See example below:

java PostFixCalc "3*(8+7)-9/(5^7)*2"

When typing an expression, be sure that the only place a unary '-' operator can be included
is at the beginning, for example:

java PostFixCalc "-3*(8+7)-9/(5^7)*2"

To make other numbers negative, add "0-" before them, for example:

java PostFixCalc "-3*(0-8+7)-9/(5^7)*2"

Finally, the program does not support assumed multiplication by parentheses, therefore
and operator must be inlcuded, for example:

java PostFixCalc "(9*7)*(3+4)"

is valid input, but:

java PostFixCalc "(9*7)(3+4)"

is not valid input.