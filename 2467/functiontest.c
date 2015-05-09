#include <stdio.h>


double add (double, double);


int main() {

  double a = 2.0;
  double b = 3.0;

  printf("The sum is %lf\n", add(a, b));

  return 0;

}


double add (double x, double y) {

  return x + y;

}
