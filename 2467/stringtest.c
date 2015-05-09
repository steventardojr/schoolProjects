#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  char *input = "this is a string";
  char *dest = malloc(strlen(input) + 1);

  strcpy(dest, input);

  printf("src\n dest\n",(int)strcpy(dest,input),dest,input);
}
