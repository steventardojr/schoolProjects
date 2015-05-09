/* Steven Tardo
   CSCI 4401, Spring 2015
   
   This program is a simple shell that
   implements the commands cd and pwd.
   If any other command is entered, the
   shell will fork a process, execute
   the command, and display the output. */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(void) {
	char input[1024]; // create string for user input
	char *args[50]; // create array of strings for arguments
	args[0] = "begin";
	char cwd[1024]; // create string for current directory
	
	// create holders for stdin and stdout
	int stdinholder = dup(0);
	close(stdinholder);
	int stdoutholder = dup(1);
	close(stdoutholder);
	
	// loop until exit
	while (strcmp(args[0], "exit") != 0) {
		// reset stdin and stdout
		dup(stdinholder);
		dup(stdoutholder);
		
		printf("%s> ", getcwd(cwd, sizeof(cwd))); // print prompt
		fgets(input, 1024, stdin); // get command
		char input_copy[1024]; // create string to tokenize args
		strcpy(input_copy, input); // copy string so original isn't modified
		int i;
		for (i = 0; i < 50; i++)
			args[i] = "\0";
		args[0] = strtok(input_copy, " \n");
		i = 1;
		while (args[i] != NULL) {
			args [i] = strtok(NULL, " \n");
			i++;
		}
		
		// set environment
		char *pathvar;
		char path_add[1024];
		pathvar = getenv("PATH");
		strcpy(path_add, pathvar);
		strcat(path_add, ":/bin");
		setenv("PATH", path_add, 0);
		
		// change directory if input is cd
		if (strcmp(args[0], "cd") == 0) {
			int ret;
			ret = chdir(args[1]);
			if (ret == -1)
				perror("");
		}
		
		// print working directory if input is pwd
		else if (strcmp(args[0], "pwd") == 0) {
			printf("%s\n", getcwd(cwd, sizeof(cwd)));
		}
		
		// otherwise fork process, execute command, and print output
		else if (strcmp(args[0], "exit") != 0) {
			pid_t pid;
			int command = 1;
			int i = 0; /* place holder for redirection or pipe argument location */
			int j = 2; /* place holder for each pipe argument location */
			int arg_location[4] = {0,0,0,0}; // array for location of redirection or pipe argument
			
			// determine location of redirection or pipes argument location
			while (args[i] != NULL) {
					if (strcmp(args[i], ">") == 0) {
						command = 2;
						arg_location[0] = i;
					}
					else if (strcmp(args[i], "<") == 0) {
						command = 2;
						arg_location[1] = i;
					}
					else if (strcmp(args[i], "|") == 0) {
						command = 3;
						arg_location[j] = i;
						j++;
					}
					i++;
			}
			
			// no redirection or pipes
			if (command == 1) {
				pid = fork(); 
				if (pid < 0)
					perror("");
				else if (pid == 0) {
					execvp(args[0], args);
					} 
				else {
					wait (NULL);
				}
			}
			
			// redirection
			else if (command == 2) {
				// redirection to stdout
				if (arg_location[1] == 0) {
					int j = arg_location[0] + 1;
					pid = fork(); 
					if (pid < 0)
						perror("");
					else if (pid == 0) {
						int fd = open(args[j], O_RDWR | O_TRUNC | O_CREAT, S_IRUSR | S_IWUSR);
						args[j-1] = NULL;
						args[j] = NULL;
						dup2(fd, 1);
						close(fd);
						execvp(args[0], args);
						} 
					else {
						wait (NULL);
					} 
				}
				// redirection to stdin and stdout
				else {
					int j = arg_location[0] + 1;
					int k = arg_location[1] + 1;
					
					pid = fork(); 
					if (pid < 0)
						perror("");
					else if (pid == 0) {
						int fd = open(args[j], O_RDWR | O_TRUNC | O_CREAT, S_IRUSR | S_IWUSR);
						int fd1 = open(args[k], O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);
						args[j-1] = NULL;
						args[j] = NULL;
						args[k] = NULL;
						args[k-1] = NULL;
						dup2(fd, 1);
						close(fd);
						dup2(fd1, 0);
						close(fd1);
						execvp(args[0], args);
						} 
					else {
						wait (NULL);
					} 
				}
			}
			
			// pipes
			else if (command == 3) {
				// two pipes
			    if (arg_location[3] == 0) {
					// set up pipe arguments
					char *args1[25];
					for (i = 0; i < 25; i++)
						args1[i] = "\0";
					
					char *args2[25];
					for (i = 0; i < 25; i++)
						args2[i] = "\0";
					
					for (i = 0; i < arg_location[2]; i++)
						args1[i] = args[i];
					args1[i] = NULL;
					
					for (i = arg_location[2]+1; i < 25; i++)
						args2[i-arg_location[2]-1] = args[i];
					
					// initialize pipe
					int fd[2];
					pipe(fd);
					
					// perform forks
				    pid = fork();
				    if (pid < 0)
						perror("");
				    else if (pid == 0) {
				        dup2(fd[1], 1);
				        execvp(args1[0], args1);
				    } 
					else {
				        close(fd[1]);
				    }

				    pid = fork();
				    if(pid < 0)
						perror("");
				    else if (pid == 0) {
					    dup2(fd[0], 0);
						close(fd[0]);
				        execvp(args2[0], args2);
				    }
					else {
						waitpid(pid, NULL, 0);
				    }
			    }
				
				// three pipes
				else {
					// set up pipe arguments
					char *args1[25];
					for (i = 0; i < 25; i++)
						args1[i] = "\0";
					
					char *args2[25];
					for (i = 0; i < 25; i++)
						args2[i] = "\0";
					
					char *args3[25];
					for (i = 0; i < 25; i++)
						args3[i] = "\0";
					
					for (i = 0; i < arg_location[2]; i++)
						args1[i] = args[i];
					args1[i] = NULL;
					
					int j = 0;
					for (i = arg_location[2]+1; i < arg_location[3]; i++) {
						args2[i-arg_location[2]-1] = args[i];
						j++;
					}
					args2[j] = NULL;
					
					j = 0;
					for (i = arg_location[3]+1; i < 25; i++) {
						args3[j] = args[i];
						j++;
					}
					
					// initialize pipes
					int fd1[2];
					int fd2[2];
					pipe(fd1);
					pipe(fd2);
					
					// perform forks
				    pid = fork();
				    if (pid < 0)
						perror("");
				    else if (pid == 0) {
				        dup2(fd1[1], 1);
				        execlp( "ls", "ls", NULL);
				    } 
					else {
				        close(fd1[1]);
				    }

				    pid = fork();
				    if(pid < 0)
						perror("");
				    else if (pid == 0) {
				        dup2(fd1[0], 0);
				        dup2(fd2[1], 1);
				        execlp( "grep", "grep", "mash", NULL);
				    }
					else {
						close(fd2[1]);
				    }
    
				    pid = fork();
				    if (pid == 0) {
				        dup2(fd2[0], 0);
				        execlp( "sort", "sort", NULL);
				    }
					waitpid(pid, NULL, 0);
				}
			}
		}
	}
	
	return 0;
}