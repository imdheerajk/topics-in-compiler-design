Instruction to Execute the programs:

All the three programmes are compiled and are provided with their .class files

Step1: go to command promt
Step 2: navigate to the folder in which program files are stored
Step3:	java Compiler_a  == To execute the program a
	java Compiler_b == To execute the program b
	java Compiler_c  ==To execute the program c

Exercise 2 . 4 . 1 : Construct recursive-descent parsers, starting with the following
grammars:
a) S -> + SS | -SS | a 
java file name: Compiler_a.java
Some valid strings: a, +aa, -aa, +-aaa, +a-aa

b) S -> S ( S ) S | e
java file name: Compiler_b.java
Some valid strings: (),(()), ()()(),((()))

c) S -> 0 S 1 | 0 1
java file name: Compiler_c.java
Some valid strings: 01, 0011, 000111, 00001111