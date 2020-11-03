This program solves problem 2.8.3 in the Programming Challenges book.

Political parties in Bangladesh show their muscle by calling for regular hartals (strikes), which cause considerable economic damage. For our purposes, each party may be characterized by a positive integer h called the hartal parameter that denotes the average number of days between two successive strikes called by the given party.

We always start the simulation on a Sunday. There are no hartals on either Fridays or Saturdays.

Given the hartal parameters for several political parties and the value of N, determine the number of working days lost in those N days.

Input
The first line of the input consists of a single integer T giving the number of test cases to follow. The first line of each test case contains an integer N (7 ≤ N ≤ 3, 650), giving the number of days over which the simulation must be run. The next line contains another integer P (1 ≤ P ≤ 100) representing the number of political parties. The ith of the next P lines contains a positive integer hi (which will never be a multiple of 7) giving the hartal parameter for party i (1 ≤ i ≤ P ).

Output
For each test case, output the number of working days lost on a separate line.
