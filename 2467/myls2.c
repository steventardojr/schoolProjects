#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <dirent.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <pwd.h>
#include <grp.h>
#include <limits.h>

int main(int argc, char **argv) {
  DIR *diropen;
  struct dirent *mydirent;
  int dirclose;
  char *userchoice = ".";
  struct passwd *mypasswd;
  struct group *mygroup;
  struct stat mystat;
  int statcheck;

  if (argc > 2) {
    printf("Invalid number of command line arguments\n");
    return 1;
  }

  if (argc == 2)
    userchoice = argv[1];

  diropen = opendir(userchoice);
  if (diropen == NULL) {
    perror("The opendir error was");
    return 1;
  }

  char *dirpath = realpath(userchoice, NULL);

  while ((mydirent = readdir(diropen))) {
    char fullpath[PATH_MAX] = { 0 };
    strcpy(fullpath, dirpath);
    strcat(fullpath, "/");
    strcat(fullpath, mydirent->d_name);

    statcheck = stat(fullpath, &mystat);
    if (statcheck == -1) {
      perror("The stat error was");
      return 1;
    }

    mypasswd = getpwuid(mystat.st_uid);
    mygroup = getgrgid(mystat.st_gid);

    char permissions[11] = "----------";

    if (S_ISDIR(mystat.st_mode))
      permissions[0] = 'd';

    if (mystat.st_mode & S_IRUSR)
      permissions[1] = 'r';
    if (mystat.st_mode & S_IWUSR)
      permissions[2] = 'w';
    if (mystat.st_mode & S_IXUSR)
      permissions[3] = 'x';

    if (mystat.st_mode & S_IRGRP)
      permissions[4] = 'r';
    if (mystat.st_mode & S_IWGRP)
      permissions[5] = 'w';
    if (mystat.st_mode & S_IXGRP)
      permissions[6] = 'x';

    if (mystat.st_mode & S_IROTH)
      permissions[7] = 'r';
    if (mystat.st_mode & S_IWOTH)
      permissions[8] = 'w';
    if (mystat.st_mode & S_IXOTH)
      permissions[9] = 'x';

    printf("%-15s", permissions);
    printf("%-12s", mypasswd->pw_name);
    printf("%-12s", mygroup->gr_name);
    printf("%-10lld", (long long) mystat.st_size);
    printf("%s\n", mydirent->d_name);
  }

  dirclose = closedir(diropen);
  if (dirclose == -1) {
    perror("THE ERROR WAS");
    return 1;
  }

  return 0;
}
