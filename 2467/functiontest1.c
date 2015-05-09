#include <stdio.h>


double add (double * x, double * y);


int main() {

  double a = 2.0;
  double b = 3.0;

  double (*add_copy)(double *, double *);
  add_copy = add;

  printf("a = %lf, b = %lf\n", a, b);
  printf("The sum is %lf\n", add_copy(&a, &b));
  printf("a = %lf, b = %lf\n", a, b);

  return 0;

}


double add (double * x, double * y) {

  *x = *x + 1.0;
  *y = *y + 1.0;

  return *x + *y;

}
