#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

int main(int argc, char **argv) {
  int myfile;
  int myfile2;
  char buffer[1024];
  size_t bufferSize;

  if (argc != 3) {
    perror("THE ERROR WAS");
    return 1;
  }

  myfile = open(argv[1], O_RDONLY);
  if (myfile == -1) {
    perror("THE ERROR WAS");
    return 1;
  }

  myfile2 = open(argv[2], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IWUSR);
  if (myfile2 == -1) {
    perror("THE ERROR WAS");
    return 1;
  }

  while ((bufferSize = read(myfile, buffer, 1024)))
    write(myfile2, buffer, bufferSize);

  close(myfile);
  close(myfile2);

  return 0;
}
