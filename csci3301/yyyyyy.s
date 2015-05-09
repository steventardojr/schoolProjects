.text

.globl main
main:
	li $t1, 10
	li $s2, 0
loop:	slt $t2, $0, $t1
	beq $t2, $0, exit
	subu $t1, $t1, 1
	addi $s2, $s2, 2
	j loop
exit:	
syscall