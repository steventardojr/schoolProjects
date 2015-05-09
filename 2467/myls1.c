#include <stdio.h>
#include <sys/types.h>
#include <dirent.h>
#include <errno.h>

int main(int argc, char **argv) {
  DIR *diropen;
  struct dirent *mydirent;
  int dirclose;
  char *userchoice = ".";

  if (argc > 2) {
    printf("Invalid number of command line arguments\n");
    return 1;
  }

  if (argc == 2)
    userchoice = argv[1];

  diropen = opendir(userchoice);
  if (diropen == NULL) {
    perror("THE ERROR WAS");
    return 1;
  }

  while ((mydirent = readdir(diropen))) {
    printf(mydirent->d_name);
    printf("\n");
  }

  dirclose = closedir(diropen);
  if (dirclose == -1) {
    perror("THE ERROR WAS");
    return 1;
  }

  return 0;
}
