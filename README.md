RushHourSolver
==============

DFID
----

---+---+-----+------+-------------+-------+---------
N  | ? | Len | Cost | Nodes       | MSec  | Solution
---+---+-----+------+-------------+-------+---------
 0 | 1 |   1 |    6 |           1 |     1 | A+5
 1 | 1 |   3 |   11 |          16 |     2 | B-1 C+2 A+5
 2 | 1 |   8 |   25 |     3178805 | 15361 | B+1 C-1 D-1 G-3 E+3 H-2 F+2 A+4
 3 | 1 |   8 |   25 |     2619489 | 11642 | C+1 B-1 F-1 E-2 G-3 D+2 H+3 A+4
 4 | 1 |   8 |   23 |     1164421 |  5504 | A+1 B+1 F-3 G-1 H-2 I-1 K+2 A+4

UCS
---

---+---+-----+------+-------------+-------+---------
N  | ? | Len | Cost | Nodes       | MSec  | Solution
---+---+-----+------+-------------+-------+---------
 0 | 1 |   1 |    6 |           5 |     4 | A+5
 1 | 1 |   3 |   11 |          25 |     2 | B-1 C+2 A+5
 2 | 1 |   8 |   25 |        1075 |   125 | B+1 C-1 D-1 H-2 G-3 F+2 E+3 A+4
 3 | 1 |   8 |   25 |        1073 |    42 | C+1 B-1 F-1 E-2 G-3 D+2 H+3 A+4
 4 | 1 |   8 |   23 |        3008 |    92 | A+1 B+1 F-3 G-1 I-1 H-2 K+2 A+4
 5 | 1 |  14 |   48 |         818 |     6 | C-2 F-3 B+3 D-1 E-1 C+3 A+1 D-3 A-1 C-3 B-3 F+3 C+3 A+4
 6 | 1 |   9 |   32 |         417 |     3 | D+3 A-1 B-3 A+1 D-3 G-2 C-3 F+3 A+4
 7 | 1 |   9 |   28 |        2526 |    24 | I-3 J+1 B+1 K-1 H-1 D-3 C+2 F+3 A+4
 8 | 1 |   9 |   28 |        2016 |    15 | A-1 I-3 E+1 D-1 J-3 C+1 K+2 F+2 A+5
 9 | 1 |  13 |   36 |        5173 |    77 | D+1 E+1 G+3 F+2 H-1 A+1 B+3 A-1 H+1 F-3 E-1 H-1 A+4
10 | 1 |  12 |   35 |         951 |     5 | B-3 H-1 G-2 E-2 I-2 A+3 M-2 C-1 K-1 J-1 F+3 A+2
11 | 1 |  12 |   30 |         734 |     4 | A+1 K-3 C-1 E+2 A+1 B+1 G-1 F+1 H-1 I-1 D-2 A+3
12 | 1 |  17 |   50 |        2213 |     9 | H-1 F-1 A+2 C+2 G+4 B+1 E+1 K-2 C-3 F+1 H+1 A-2 I-4 L-1 D-1 F+2 A+4
13 | 1 |  25 |   82 |         847 |     2 | E+3 A-1 F-2 C-1 G-3 D+1 C+1 F+3 A+1 E-3 C-3 H+1 B+3 H-1 C+3 E+3 A-1 F-4 A+1 E-3 C-3 G+2 D-3 H+3 A+4
14 | 1 |  17 |   51 |        1177 |     4 | F+2 H-1 C-2 G-3 C+2 D+3 H+3 F-1 G-1 A+3 B+1 F-2 H-3 C-1 D-1 E+3 A+2
15 | 1 |  16 |   49 |       10293 |   109 | F-1 D+1 I+1 E+2 A-3 J-3 M-1 E-2 D-2 C-2 F+3 H+3 G+2 E-1 J-1 A+5
16 | 1 |  17 |   52 |       14052 |   521 | I+1 E+1 A-2 G+1 B+3 G-1 A+2 I-3 E-3 L-2 A-2 K-2 C-4 J+1 D+1 K+1 A+5
17 | 1 |  23 |   56 |         525 |     2 | N+1 M+1 L+1 G+1 C+1 A-2 D-1 I-1 J-2 F+1 K+1 B-1 E+2 D-2 I-2 A+2 C-1 L-1 M-2 N-2 K+1 F+1 A+3
18 | 1 |  21 |   63 |        2688 |    11 | K+1 D+1 E+2 A-3 H+1 G+1 I-2 K-3 J+2 D+1 C-2 H+3 C+2 D-1 J-2 K+3 A+3 K-3 C-1 F+3 A+2
19 | 1 |  24 |   72 |        2159 |     8 | G-1 J-2 D-2 K-2 C+3 L+3 E+2 I+1 A+1 B+4 I-1 A-1 G-1 F+2 E-4 A+1 I+1 B-2 C-3 J+1 D+1 L-3 K+2 A+4
20 | 1 |  25 |   86 |        1615 |     4 | D+3 I+1 A-1 C+2 E+3 G+4 A+1 B+1 H+1 I-3 C-3 F+2 B+3 H+3 F-2 C+3 I+3 A-1 G-4 A+1 I-3 D-3 C-3 F+3 A+4
21 | 1 |  22 |   67 |         510 |     1 | D-2 A-2 B+1 F-1 G-1 C-1 E+2 H-2 B+3 H+2 A+2 D+4 A-2 F-2 H-2 B-4 H+2 A+2 D-2 E-2 C+1 A+3
22 | 1 |  10 |   29 |        1927 |    11 | H+1 G+2 E-2 I-2 C-1 J+1 D-3 I+1 H+1 A+5
23 | 1 |  21 |   71 |         260 |     1 | G+2 A-1 C+2 F+4 A+1 B+1 G-3 C-3 E+1 B+3 E-1 C+3 G+3 A-1 F-4 A+1 G-3 D-3 C-3 E+3 A+4
24 | 1 |  26 |   73 |        4653 |    32 | J+1 G-1 A-1 B+3 A+1 G+1 F-3 K-1 I-1 L-2 J+1 D-1 C+2 B+1 E+1 I-2 K+2 H-3 L-2 K-2 I+3 E-1 B-1 C-3 K+3 A+4
25 | 1 |  29 |   79 |        2745 |    11 | C-2 E+1 I-1 J+1 F+1 B-1 A-3 B+1 F-1 J-1 I+1 E-1 C+3 H+1 B+1 G-3 E-2 I-1 J+1 F+1 B-2 I-3 H-2 D-4 H+1 C-1 J+2 E+2 A+5
26 | 1 |  26 |   77 |        4318 |    26 | H-1 F+1 C+1 E+2 D-1 A-2 B+1 G-1 I-2 J-2 C+2 F+2 B+3 A+2 D+2 H+4 D-2 G-2 A-2 B-4 D+2 A+2 H-2 F-2 J+1 A+3
27 | 1 |  27 |   80 |        8828 |    64 | K+1 A-1 H-1 I-1 F-1 C+2 G+4 B+1 E+1 A+1 K-3 C-3 J-3 C+3 K+3 E-1 M-1 A-1 B-1 G-4 L-2 C-2 F+3 H+1 J-1 I+2 A+5
28 | 1 |  28 |   78 |        4839 |    19 | I+1 K-1 E-1 J-1 C+1 H+3 A+1 B+1 F-3 L-1 K+2 B+3 A-1 K-2 H-4 C-1 J+1 A+1 K+3 I-1 D-1 E-1 B-3 C-3 D+1 K-2 L+3 A+3
29 | 1 |  28 |   86 |        2872 |    10 | J-2 I+1 F+2 H+2 G+2 E-2 A+1 B+4 A-1 E+2 H-3 E-1 G-3 F-2 I-4 E+1 F+2 H+3 E-2 I+1 A+1 B-3 I-1 D-1 C-3 F+1 J+3 A+4
30 | 1 |  30 |   82 |        2174 |     7 | B+1 L-1 J+2 D+2 H+1 F+3 K-1 E+1 I-3 B+1 G-1 L-1 C+1 K+2 G-3 B-1 K-2 I+3 E-1 H-1 D-2 J-1 K+3 F-3 B-1 A+3 K-2 C-1 L+2 A+2
31 | 1 |  24 |   72 |        6796 |    46 | G-1 I+1 J-2 C+3 H+1 E-1 D+2 B+3 E+1 F+1 A+1 H-4 E-1 A-1 B-3 D-2 C-3 J+2 I-2 K+3 F+2 B-1 G+2 A+5
32 | 1 |  32 |   88 |        1171 |     3 | C-1 E+1 D+2 I+1 H+1 F+3 A-1 B+1 J-1 C-2 E+1 G+3 E-1 C+1 J+1 B-1 A+3 F-3 H-1 I-1 B+4 H+1 F+1 J-3 C-1 E+1 A-2 G-4 E-1 D-1 C+3 A+4
33 | 1 |  37 |  107 |        3948 |    14 | B+1 E-2 A-1 C-2 D+3 C+2 A+1 E+4 B-1 A-1 C-3 I-3 G+1 H-1 K-1 D+1 G+1 C+3 A+3 C-3 I+1 E-3 I-1 C+3 B+1 E-1 A-3 G-1 C-2 D-4 G+1 C+2 A+3 C-1 J-1 K+2 A+2
34 | 1 |  37 |  100 |         607 |     2 | G+1 H-1 K-3 D+1 J-1 C+4 J+1 D-1 E+1 K+1 H+1 G-1 I-1 F+3 A+3 F-3 I+1 E-3 I-1 F+3 B+1 E-1 A-3 G+1 H-1 K-1 D+1 J-1 F-1 C-4 J+1 D-1 K+3 H+1 F+1 G-1 A+5
35 | 1 |  40 |  118 |        4070 |    20 | G-1 K-3 I+1 J-3 C+1 L+1 E-1 I-2 H-3 I+2 C+2 D+3 F+3 G-1 H-1 J+2 A+3 B+1 G-2 F-3 E+1 L-3 E-1 F+3 G+2 B-1 L-1 A-3 J-1 F-2 D-4 J+1 F+2 A+3 F-1 C-3 J+1 I-1 K+3 A+2
36 | 1 |  43 |  115 |        4413 |    17 | A+1 H-1 B+1 F-3 K-1 J+1 E+1 C+3 I-1 G-1 L+1 B+3 A-1 I-2 C-3 K+1 E-2 D-3 E+2 G+1 F+3 I-1 A+1 C+1 B-4 A-1 D-1 I+1 F-1 L-1 K-1 C+2 I+3 C-3 E-1 A+1 B+1 F-2 G-1 J-1 H-1 K+3 A+4
37 | 1 |  43 |  119 |        3948 |    14 | J+1 H+1 K+1 B+1 C-1 G-1 I-2 D-3 E+3 I+2 G+1 B-1 K-1 C+3 H-1 J-1 F+3 A+1 H-3 A-1 F-3 C-3 K+1 B+1 G-1 I-2 E-4 I+2 G+1 B-1 K-1 C+3 F+3 A+1 H+1 B-3 G-1 D-1 A+2 F-3 C-1 K+3 A+2
38 | 1 |  44 |  109 |        2864 |    10 | E+1 L+1 F+1 K-1 B-1 A+1 C-1 H+1 L+2 I-3 L-1 C+1 B+1 K+1 F-1 L-2 E-1 J+4 E+1 L+1 F+1 K-1 B-1 C-1 L+2 I+3 L-1 C+1 B+1 K+1 F-1 G+3 A-2 L-2 H-2 E-3 L+1 F+1 D-1 J-1 K-1 E-1 C+2 A+4
39 | 1 |  47 |  113 |        1949 |     6 | J+1 C+1 A-1 G+1 H-2 K-1 F-1 L+2 G+2 A+1 C-1 J-1 G+1 L-2 F+1 H+1 B+1 E+1 C-2 L-1 I-3 L+1 C+1 B-1 H-1 F-1 L+2 G-1 J+1 C+2 A-1 E-1 G-2 L-2 F+1 K+1 H+2 G-1 A+1 C-1 J-1 I-1 M-2 D-2 K+2 F+2 A+4
40 | 1 |  48 |  126 |        3962 |    14 | F-1 K-2 I+1 H+1 G+2 E-1 J+1 D-1 C-3 H+2 I-1 K+1 F+1 E-1 A+1 B+3 A-1 E+1 F-1 K-1 I+1 H-1 C+3 B+1 D+1 E+1 G-3 E-1 H-2 I-4 K+1 E+1 H+1 F+1 G+3 E-2 I+1 A+1 B-4 A-1 I-1 D-2 C-1 J-4 H+1 D+1 K+2 A+5
41 | 1 |  50 |  133 |        3803 |     9 | K+1 L+2 H+2 B+1 F-1 C-2 K+1 I+1 G+3 I-1 C+1 F+1 B-1 A+3 B+1 F-1 C-1 I+1 E+2 J-4 D-4 E-2 I-1 C+1 F+1 B-1 A-3 B+1 F-1 C-1 I+1 G-3 I-1 C+1 F+1 B-1 H-2 K-4 H+1 B+1 F-1 C-1 I+1 L-3 G+3 I-1 C+3 F+1 B-1 A+5
42 | 1 |  51 |  133 |        3105 |    13 | M+1 K-1 I+1 C+3 D-1 L+1 F+3 B-1 E-1 H+2 A-3 G+1 E+1 B+3 E-1 A+2 F-3 L-1 D+1 H-3 C-3 K+1 A-1 B+1 I-4 A+1 C+2 H+3 A-1 I+1 B-1 K-1 C+1 D-1 L+1 F+3 A-1 E+1 B-3 E-1 A+1 F-1 J-1 L-1 M-1 G-1 I-1 D+1 C-1 K+3 A+4
---+---+-----+------+-------------+-------+---------
 0 | 1 |1034 | 2943 |      127152 |  1419 |


UCS W/ OPTIMIZATIONS:

---+---+-----+------+-------------+-------+---------
N  | ? | Len | Cost | Nodes       | MSec  | Solution
---+---+-----+------+-------------+-------+---------
 0 | 1 |   1 |    6 |           5 |     3 | A+5
 1 | 1 |   3 |   11 |          25 |     2 | B-1 C+2 A+5
 2 | 1 |   8 |   25 |        1076 |    98 | B+1 C-1 D-1 H-2 G-3 F+2 E+3 A+4
 3 | 1 |   8 |   25 |        1073 |    34 | C+1 B-1 F-1 E-2 G-3 D+2 H+3 A+4
 4 | 1 |   8 |   23 |        2922 |    57 | A+1 B+1 F-3 G-1 I-1 H-2 K+2 A+4
 5 | 1 |  14 |   48 |         818 |    13 | C-2 F-3 B+3 D-1 E-1 C+3 A+1 D-3 A-1 C-3 B-3 C+3 F+3 A+4
 6 | 1 |   9 |   32 |         413 |     6 | D+3 A-1 B-3 A+1 D-3 G-2 C-3 F+3 A+4
 7 | 1 |   9 |   28 |        2569 |    42 | I-3 J+1 B+1 K-1 H-1 D-3 C+2 F+3 A+4
 8 | 1 |   9 |   28 |        2016 |     9 | A-1 I-3 E+1 D-1 J-3 C+1 K+2 F+2 A+5
 9 | 1 |  14 |   36 |        5322 |    30 | D+1 E+1 G+1 F+2 H-1 A+1 B+3 A-1 H+1 F-3 G-1 E-1 H-1 A+4
10 | 1 |  12 |   35 |         951 |     2 | B-3 H-1 G-2 E-2 I-2 A+3 M-2 K-1 J-1 C-1 F+3 A+2
11 | 1 |  12 |   30 |         780 |     2 | A+1 K-3 C-1 F+1 E+2 A+1 B+1 G-1 H-1 I-1 D-2 A+3
12 | 1 |  17 |   50 |        2142 |     7 | H-1 F-1 A+2 C+2 G+4 B+1 E+1 A-2 K-2 C-3 I-2 L-1 D-1 F+3 H+1 I-2 A+4
13 | 1 |  25 |   82 |         850 |     2 | E+3 A-1 F-2 C-1 G-3 D+1 C+1 F+3 A+1 E-3 C-3 H+1 B+3 H-1 C+3 E+3 A-1 F-4 A+1 E-3 C-3 G+2 D-3 H+3 A+4
14 | 1 |  17 |   51 |        1176 |     3 | F+2 H-1 C-2 G-3 C+2 D+3 H+3 A+1 B+1 F-3 G-1 A+2 H-3 C-1 D-1 E+3 A+2
15 | 1 |  16 |   49 |       10171 |    41 | F-1 D+1 I+1 E+2 A-3 J-3 M-1 E-2 D-2 C-2 H+3 F+3 G+2 J-1 E-1 A+5
16 | 1 |  17 |   52 |       13932 |    83 | I+1 E+1 A-2 G+1 B+3 G-1 A+2 I-3 E-3 L-2 A-2 K-2 C-4 D+1 J+1 K+1 A+5
17 | 1 |  23 |   56 |         525 |     2 | N+1 M+1 L+1 G+1 C+1 A-2 D-1 I-1 J-2 F+1 K+1 B-1 E+2 D-2 I-2 A+2 C-1 L-1 M-2 N-2 K+1 F+1 A+3
18 | 1 |  21 |   63 |        2759 |     9 | K+1 D+1 E+2 A-3 H+1 G+1 I-2 K-3 J+2 D+1 C-2 H+3 C+2 D-1 J-2 K+3 A+3 K-3 C-1 F+3 A+2
19 | 1 |  24 |   72 |        2165 |     8 | G-1 J-2 D-2 K-2 C+3 L+3 E+2 I+1 A+1 B+4 A-1 I-1 G-1 F+2 E-4 A+1 I+1 B-2 C-3 J+1 D+1 L-3 K+2 A+4
20 | 1 |  25 |   86 |        1618 |     4 | D+3 I+1 A-1 C+2 E+3 G+4 B+1 H+1 A+1 I-3 C-3 F+2 B+3 H+3 F-2 C+3 I+3 A-1 G-4 A+1 I-3 D-3 C-3 F+3 A+4
21 | 1 |  22 |   67 |         503 |     1 | D-2 A-2 B+1 F-1 G-1 C-1 E+2 H-2 B+3 H+2 A+2 D+4 A-2 F-2 H-2 B-4 H+2 A+2 D-2 E-2 C+1 A+3
22 | 1 |  10 |   29 |        2145 |     7 | H+1 G+2 E-2 I-2 C-1 J+1 D-3 I+1 H+1 A+5
23 | 1 |  21 |   71 |         261 |     0 | G+2 A-1 C+2 F+4 B+1 A+1 G-3 C-3 E+1 B+3 E-1 C+3 G+3 A-1 F-4 A+1 G-3 C-3 D-3 E+3 A+4
24 | 1 |  26 |   73 |        4547 |    16 | J+1 G-1 A-1 B+3 A+1 G+1 F-3 K-1 I-1 L-2 C+2 E+1 J+1 B+1 I-2 K+2 H-3 L-2 K-2 I+3 B-1 E-1 D-1 C-3 K+3 A+4
25 | 1 |  29 |   79 |        2741 |     7 | C-2 E+1 I-1 J+1 F+1 B-1 A-3 B+1 F-1 J-1 I+1 E-1 C+3 H+1 B+1 G-3 E-2 I-1 J+1 F+1 B-2 I-3 H-2 D-4 H+1 C-1 J+2 E+2 A+5
26 | 1 |  26 |   77 |        4292 |    14 | H-1 F+1 C+1 E+2 A-2 B+1 G-1 D-1 I-2 J-2 F+2 C+2 B+3 A+2 D+2 H+4 G-2 A-2 D-2 B-4 D+2 A+2 H-2 F-2 J+1 A+3
27 | 1 |  27 |   80 |        8839 |    37 | K+1 A-1 H-1 I-1 F-1 C+2 G+4 A+1 B+1 E+1 K-3 C-3 J-3 M-1 C+3 K+3 E-1 A-1 B-1 G-4 L-2 C-2 F+3 H+1 J-1 I+2 A+5
28 | 1 |  28 |   78 |        4838 |    17 | I+1 K-1 E-1 J-1 C+1 H+3 A+1 B+1 F-3 L-1 K+2 B+3 A-1 K-2 H-4 C-1 J+1 K+3 I-1 E-1 D-1 A+1 B-3 C-3 D+1 K-2 L+3 A+3
29 | 1 |  28 |   86 |        2893 |     7 | J-2 I+1 F+2 H+2 G+2 E-2 A+1 B+4 A-1 E+2 H-3 E-1 G-3 F-2 I-4 E+1 F+2 H+3 E-2 I+1 A+1 B-3 I-1 D-1 C-3 F+1 J+3 A+4
30 | 1 |  30 |   82 |        2127 |     6 | B+1 L-1 J+2 D+2 H+1 F+3 K-1 E+1 I-3 B+1 G-1 L-1 C+1 K+2 G-3 B-1 K-2 I+3 H-1 E-1 D-2 K+3 F-3 B-1 J-1 A+3 K-2 C-1 L+2 A+2
31 | 1 |  24 |   72 |        6803 |    25 | G-1 I+1 J-2 C+3 H+1 E-1 D+2 B+3 A+1 F+1 E+1 H-4 A-1 E-1 B-3 D-2 C-3 J+2 I-2 K+3 F+2 B-1 G+2 A+5
32 | 1 |  32 |   88 |        1170 |     3 | C-1 E+1 D+2 I+1 H+1 F+3 A-1 B+1 J-1 C-2 E+1 G+3 E-1 C+1 J+1 B-1 A+3 F-3 H-1 I-1 B+4 H+1 F+1 J-3 C-1 E+1 A-2 G-4 E-1 D-1 C+3 A+4
33 | 1 |  37 |  107 |        3970 |    12 | B+1 E-2 A-1 C-2 D+3 C+2 A+1 E+4 B-1 A-1 C-3 I-3 G+1 H-1 K-1 D+1 G+1 C+3 A+3 C-3 I+1 E-3 I-1 C+3 B+1 E-1 A-3 G-1 C-2 D-4 G+1 C+2 A+3 C-1 J-1 K+2 A+2
34 | 1 |  37 |  100 |         600 |     2 | G+1 H-1 K-3 D+1 J-1 C+4 J+1 D-1 E+1 K+1 H+1 I-1 G-1 F+3 A+3 F-3 I+1 E-3 I-1 F+3 B+1 E-1 A-3 G+1 F-1 H-1 K-1 D+1 J-1 C-4 J+1 D-1 K+3 H+1 F+1 G-1 A+5
35 | 1 |  40 |  118 |        4075 |    15 | G-1 K-3 I+1 J-3 C+1 L+1 E-1 I-2 H-3 I+2 C+2 D+3 F+3 G-1 H-1 J+2 A+3 B+1 G-2 F-3 E+1 L-3 E-1 F+3 G+2 L-1 B-1 A-3 J-1 F-2 D-4 J+1 F+2 A+3 F-1 C-3 J+1 I-1 K+3 A+2
36 | 1 |  43 |  115 |        4409 |    24 | J+1 H-1 F-1 K-1 A+1 E+1 C+3 I-1 L+1 B+4 A-1 F-2 G-1 I-2 C-3 E-2 D-3 E+2 G+1 C+1 K+1 F+3 I-1 A+1 B-4 A-1 I+1 F-1 D-1 L-1 K-1 C+2 I+3 A+1 B+1 F-2 H-1 C-3 E-1 G-1 J-1 K+3 A+4
37 | 1 |  43 |  119 |        3962 |    11 | J+1 K+1 B+1 G-1 H+1 C-1 I-2 D-3 E+3 I+2 G+1 B-1 K-1 C+3 H-1 J-1 F+3 A+1 H-3 A-1 F-3 C-3 K+1 B+1 G-1 I-2 E-4 I+2 G+1 B-1 K-1 C+3 F+3 A+1 H+1 B-3 G-1 D-1 A+2 F-3 C-1 K+3 A+2
38 | 1 |  45 |  109 |        2884 |     7 | E+1 L+1 F+1 K-1 B-1 A+1 C-1 H+1 L+2 I-3 L-1 C+1 B+1 K+1 F-1 L-2 E-1 J+4 E+1 L+1 F+1 K-1 B-1 C-1 L+2 I+3 L-1 C+1 B+1 K+1 F-1 G+3 L-2 A-2 E-2 J-1 D-1 C+2 H+1 E-1 L+1 F+1 K-1 E-1 A+4
39 | 1 |  47 |  113 |        1951 |     5 | J+1 C+1 A-1 G+1 H-2 K-1 F-1 L+2 G+2 A+1 C-1 J-1 G+1 L-2 F+1 H+1 B+1 E+1 C-2 L-1 I-3 L+1 C+1 B-1 H-1 F-1 L+2 G-1 J+1 C+2 A-1 E-1 G-2 L-2 F+1 K+1 H+2 I-1 G-1 A+1 C-1 J-1 M-2 D-2 F+2 K+2 A+4
40 | 1 |  48 |  126 |        3943 |    11 | F-1 K-2 I+1 H+1 G+2 E-1 J+1 D-1 C-3 H+2 I-1 K+1 F+1 E-1 A+1 B+3 A-1 E+1 F-1 K-1 I+1 H-1 C+3 D+1 B+1 E+1 G-3 E-1 H-2 I-4 K+1 E+1 H+1 F+1 G+3 E-2 I+1 A+1 B-4 I-1 A-1 D-2 J-4 D+1 H+1 C-1 K+2 A+5
41 | 1 |  50 |  133 |        3800 |     8 | K+1 L+2 H+2 B+1 F-1 C-2 K+1 I+1 G+3 I-1 C+1 F+1 B-1 A+3 B+1 F-1 C-1 I+1 E+2 J-4 D-4 E-2 I-1 C+1 F+1 B-1 A-3 B+1 F-1 C-1 I+1 G-3 I-1 C+1 F+1 B-1 H-2 K-4 H+1 B+1 F-1 C-1 I+1 L-3 G+3 I-1 C+3 F+1 B-1 A+5
42 | 1 |  51 |  133 |        3149 |     9 | M+1 K-1 I+1 C+3 D-1 L+1 F+3 B-1 E-1 H+2 A-3 G+1 E+1 B+3 E-1 A+2 F-3 L-1 D+1 H-3 C-3 K+1 A-1 B+1 I-4 A+1 C+2 H+3 A-1 I+1 B-1 K-1 C+1 D-1 L+1 F+3 A-1 E+1 B-3 E-1 A+1 F-1 L-1 D+1 C-1 G-1 J-1 I-1 M-1 K+3 A+4
---+---+-----+------+-------------+-------+---------
 0 | 1 |1036 | 2943 |      127210 |   701 |


PHS WITH OPTIMIZATIONS:

---+---+-----+------+-------------+-------+---------
N  | ? | Len | Cost | Nodes       | MSec  | Solution
---+---+-----+------+-------------+-------+---------
 0 | 1 |   1 |    6 |           1 |     3 | A+5
 1 | 1 |   3 |   13 |           9 |     2 | B+3 C+2 A+5
 2 | 1 |   8 |   25 |         582 |    81 | G-3 E+3 B+1 C-1 D-1 H-2 F+2 A+4
 3 | 1 |   8 |   26 |         593 |    27 | G-3 H+3 C+2 B-1 F-1 E-2 D+2 A+4
 4 | 1 |  10 |   29 |         732 |    27 | G+2 F-2 H-2 A+1 B+1 F-1 G-3 I-1 K+2 A+4
 5 | 1 |  15 |   53 |         516 |    11 | C-2 B+1 D-1 E-2 F-3 B+2 C+3 A+1 D-3 A-2 C-3 B-4 C+3 F+3 A+5
 6 | 1 |   9 |   32 |         145 |     3 | D+3 A-1 B-3 A+1 D-3 C-3 G-2 F+3 A+4
 7 | 1 |   9 |   28 |         597 |    12 | I-3 J+1 D-3 C+2 B+1 K-1 H-1 F+3 A+4
 8 | 1 |  10 |   29 |         656 |    14 | J-2 F+2 K+2 A-1 I-3 E+1 D-1 J-1 C+1 A+5
 9 | 1 |  13 |   38 |        2516 |    60 | D+1 G+3 E+1 F+2 H-1 A+2 B+3 A-2 H+1 F-3 E-1 H-1 A+4
10 | 1 |  12 |   35 |         663 |    11 | B-3 H-1 G-2 I-2 E-2 A+3 M-2 J-1 K-1 C-1 F+3 A+2
11 | 1 |  12 |   31 |         362 |     5 | F+1 A+1 K-3 C-1 E+2 A+2 B+1 I-2 G-1 H-1 D-2 A+2
12 | 1 |  17 |   50 |        1443 |    19 | H-1 F-1 A+2 C+2 G+4 A-2 B+1 E+1 K-2 C-3 F+1 H+1 I-4 D-1 L-1 F+2 A+4
13 | 1 |  30 |   99 |         730 |     8 | E+3 B-1 A-1 F-3 C-1 G-4 D+1 C+1 F+4 B+1 A+1 E-3 C-3 G+3 H+2 B+3 H-2 C+2 E+3 A-1 G-2 C+1 F-4 A+1 E-3 C-3 G+2 D-3 H+3 A+4
14 | 1 |  17 |   55 |         636 |     3 | F+2 H-1 C-3 G-3 D+3 C+3 H+3 F-1 G-1 A+3 B+2 F-2 H-3 C-1 D-2 E+3 A+2
15 | 1 |  18 |   51 |        5258 |    28 | F-1 D+1 E+2 I+1 A-3 J-3 M-1 C-1 D-1 F+3 H+1 G+2 J-1 E-3 C-1 D-1 H+2 A+5
16 | 1 |  18 |   57 |        4547 |    26 | C-1 J+1 E-1 I-1 L-2 K-1 F+4 K+1 L+2 I+3 E+3 L-2 A-2 G+2 H-4 D-2 G-2 A+5
17 | 1 |  23 |   56 |         520 |     2 | N+1 M+1 L+1 G+1 B-1 C+1 A-2 I-1 D-1 J-2 K+1 F+1 E+2 D-2 I-2 A+2 C-1 L-1 M-2 N-2 K+1 F+1 A+3
18 | 1 |  21 |   65 |        1897 |     8 | E+2 J+3 D+2 K+1 I-2 A-3 H+1 G+1 K-3 C-2 J-1 H+3 C+2 D-1 J-2 K+3 A+3 K-3 C-1 F+3 A+2
19 | 1 |  25 |   73 |        1714 |     9 | F+2 G-1 K-2 D-2 J-2 C+3 L+3 E+2 A+1 I+1 B+4 I-1 G-1 A-1 E-4 C-2 D+1 J+1 A+1 I+1 B-2 L-3 C-1 K+2 A+4
20 | 1 |  25 |   86 |        1379 |     5 | C+2 D+3 I+1 A-1 E+3 G+4 A+1 B+1 H+1 I-3 C-3 F+2 H+3 B+3 F-2 C+3 I+3 A-1 G-4 A+1 I-3 C-3 D-3 F+3 A+4
21 | 1 |  22 |   69 |         471 |     2 | D-2 A-2 B+1 F-1 G-1 H-2 C-1 E+2 B+3 H+2 A+2 D+4 H-2 F-2 A-2 B-4 A+2 H+2 D-2 E-3 C+2 A+3
22 | 1 |  10 |   31 |         925 |     3 | H+1 G+3 E-2 I-2 D-3 H+1 I+1 C-2 J+1 A+5
23 | 1 |  21 |   71 |         241 |     1 | G+2 A-1 C+2 F+4 A+1 B+1 G-3 C-3 E+1 B+3 E-1 C+3 G+3 A-1 F-4 A+1 G-3 D-3 C-3 E+3 A+4
24 | 1 |  27 |   76 |        2386 |    11 | J+1 G-1 A-1 B+3 A+1 G+1 F-3 K-1 I-1 L-1 C+2 B+1 E+1 I-3 L-1 J+1 K+2 H-3 L-2 K-2 I+4 D-1 B-1 E-1 C-3 K+3 A+4
25 | 1 |  31 |   88 |        1743 |    10 | C-2 E+1 I-1 J+1 F+1 B-1 A-3 B+1 F-3 J-1 I+1 E-1 C+3 H+1 B+1 G-3 E-3 B-1 I-4 H-1 D-1 C-2 J+3 E+1 F+3 B-1 H-1 D-3 H+1 E+2 A+5
26 | 1 |  25 |   81 |        4027 |    23 | H-1 E-2 A-2 D-1 B+2 G-1 I-2 J-2 C+4 F+3 B+2 A+2 D+2 H+4 E+4 G-2 D-2 A-2 B-4 D+2 A+2 H-2 F-2 J+1 A+3
27 | 1 |  27 |   80 |        6801 |    57 | H-1 I-1 K+1 F-1 C+2 A-1 G+4 A+1 B+1 E+1 K-3 C-3 J-3 C+3 K+3 A-1 B-1 E-1 G-4 L-2 C-2 I+2 M-1 F+3 H+1 J-1 A+5
28 | 1 |  29 |   79 |        3621 |    23 | F-1 E-2 I+1 K-1 H+2 J-1 C+1 A+1 B+1 H+1 F-2 L-1 K+2 B+3 K-2 A-1 H-4 A+1 C-1 J+1 K+3 B-3 D-1 I-1 C-3 D+1 K-2 L+3 A+3
29 | 1 |  28 |   88 |        2327 |    12 | J-2 I+1 F+2 H+2 G+2 E-2 A+1 B+4 A-1 E+2 H-3 G-3 E-2 F-2 I-4 F+2 E+2 H+3 E-2 A+1 I+1 B-3 I-1 D-1 C-3 F+1 J+3 A+4
30 | 1 |  30 |   82 |        1222 |     6 | L-1 J+2 D+2 E+1 H+1 B+1 F+3 K-1 I-3 B+1 G-1 L-1 C+1 K+2 G-3 K-2 B-1 I+3 E-1 H-1 D-2 K+3 F-3 B-1 A+3 K-2 C-1 J-1 L+2 A+2
31 | 1 |  26 |   86 |        5521 |    37 | G-2 I+1 J-4 C+3 D+3 H+1 E-1 B+3 J+3 A+1 E+1 F+1 H-4 E-1 A-1 B-3 C-3 J-1 D-4 J+2 I-2 K+3 G+4 F+2 B-1 A+5
32 | 1 |  33 |   96 |        1032 |     6 | D+1 I+1 E+1 H+1 F+3 A-1 B+1 J-3 G-1 C-3 E+1 D+1 G+4 E-1 C+1 J+3 B-1 A+3 F-3 I-1 H-1 B+4 H+1 F+2 J-3 A-2 C-1 E+1 G-4 D-1 E-1 C+3 A+4
33 | 1 |  37 |  107 |        3691 |    17 | B+1 E-2 A-1 C-2 D+3 C+2 A+1 E+4 A-1 B-1 C-3 I-3 C+3 G+1 H-1 K-1 D+1 G+1 A+3 C-3 I+1 E-3 I-1 C+3 B+1 E-1 A-3 C-2 G-1 D-4 G+1 C+2 A+3 C-1 J-1 K+2 A+2
34 | 1 |  38 |  103 |         502 |     1 | C+1 E+1 I-1 G+1 H-1 K-3 D+1 J-1 C+3 F+3 J+1 D-1 K+1 H+1 G-1 A+3 F-3 I+1 E-3 I-1 F+3 B+1 E-1 A-3 G+1 H-1 K-1 D+1 J-1 F-2 C-4 F+2 J+1 D-1 K+3 H+1 G-1 A+5
35 | 1 |  41 |  120 |        2449 |    12 | G-1 K-3 I+1 J-1 C+1 L+1 E-1 J-2 I-2 H-3 I+2 D+3 J+2 C+2 F+3 G-1 H-1 A+3 B+1 G-2 F-3 E+1 L-3 E-1 F+3 G+2 L-1 B-1 A-3 J-1 F-2 D-4 F+2 J+1 A+3 F-2 C-3 J+1 I-1 K+3 A+2
36 | 1 |  44 |  122 |        3973 |    25 | A+1 B+1 F-3 G-1 H-2 J+1 E+1 K-1 C+3 I-1 L+1 B+3 A-1 I-2 C-3 E-2 D-3 E+2 H+3 K+1 G+1 F+3 I-1 A+1 C+1 B-4 D-1 L-1 A-1 I+1 F-2 H-3 K-1 C+2 I+3 A+1 B+1 F-1 G-1 C-3 E-1 J-1 K+3 A+4
37 | 1 |  47 |  142 |        3748 |    19 | C+2 F+1 B-3 G-1 J+1 H+1 F-1 C-3 D-4 I-2 E+3 I+2 C+3 H-1 J-1 F+3 A+2 B+1 H-3 A-2 G+1 D+1 B+2 F-3 C-3 K+1 B+1 G-1 I-2 E-4 K+2 I+2 D+3 G+1 B-1 K-3 C+3 F+3 B-2 G-1 A+3 H+2 B-1 F-3 C-1 K+3 A+2
38 | 1 |  44 |  110 |        2092 |     9 | E+1 L+1 F+1 K-1 B-1 H+1 C-1 A+1 L+2 I-3 L-2 C+1 B+1 K+1 F-1 L-1 E-1 J+4 E+1 L+1 F+1 K-1 B-1 C-1 L+2 I+3 G+3 L-1 H-2 C+1 B+1 K+1 F-1 A-2 L-2 E-3 D-1 J-1 C+2 L+2 F+1 K-1 E-1 A+4
39 | 1 |  52 |  128 |        1832 |     8 | J+1 C+1 A-1 G+1 H-2 K-1 F-1 L+2 G+2 A+1 C-1 J-1 G+1 L-2 K+1 F+1 H+2 B+1 E+1 C-2 L-1 I-4 M-1 D-1 K+2 L+1 C+2 E-1 B-1 I+1 H-2 F-1 K-3 L+2 G-1 J+1 C+1 A-1 G-2 L-2 K+3 F+1 H+2 G-1 I-1 A+2 C-1 D-1 J-1 M-1 F+2 A+3
40 | 1 |  49 |  142 |        3178 |    20 | F-2 K-2 I+1 J+1 H+2 G+2 E-1 D-1 C-3 H+1 I-1 K+1 F+2 E-1 A+2 B+3 A-2 E+1 F-3 K-1 I+1 H-1 C+3 D+1 B+1 E+1 G-3 E-1 H-3 I-4 E+1 H+3 K+1 G+3 F+3 E-2 I+1 A+2 B-4 I-1 A-2 D-2 H-1 J-4 D+1 H+1 C-2 K+2 A+5
41 | 1 |  55 |  151 |        3520 |    17 | C+1 K+1 H+1 B+1 F-3 G-1 C-3 K+1 L+2 I+1 G+4 I-1 C+1 F+3 B-1 A+3 B+1 F-1 H+1 C-1 I+1 E+2 J-4 D-4 E-2 I-1 C+1 F+1 B-1 H-1 A-3 B+1 F-1 C-1 I+1 G-3 I-1 L-4 K-1 C+3 F+1 B-1 H-1 K-3 H+1 B+1 F-1 C-3 I+1 G+3 I-1 C+3 F+1 B-1 A+5
42 | 1 |  52 |  138 |        2454 |    13 | M+1 K-1 I+1 C+3 D-1 L+1 F+3 B-1 E-1 H+2 A-3 E+1 G+1 B+3 E-1 A+2 F-3 L-1 H-3 A-1 D+1 C-3 K+1 B+1 I-4 J-1 M-1 K+2 C+2 A+1 H+3 A-1 I+1 B-1 K-3 C+1 D-1 L+1 F+3 A-1 E+1 B-3 I-1 E-1 G-1 A+1 F-1 L-1 D+1 C-1 K+3 A+4
---+---+-----+------+-------------+-------+---------
 0 | 1 |1072 | 3127 |       83252 |   696 |


A*:

EIDA*:

---+---+-----+------+-------------+-------+---------
N  | ? | Len | Cost | Nodes       | MSec  | Solution
---+---+-----+------+-------------+-------+---------
 0 | 1 |   1 |    6 |          13 |     4 | A+5
 1 | 1 |   3 |   11 |          80 |     8 | B-1 C+2 A+5
 2 | 1 |   8 |   25 |        9387 |   242 | B+1 C-1 D-1 G-3 E+3 H-2 F+2 A+4
 3 | 1 |   8 |   25 |        9451 |    31 | C+1 B-1 F-1 E-2 G-3 D+2 H+3 A+4
 4 | 1 |   8 |   23 |       11124 |    34 | A+1 B+1 F-3 G-1 H-2 I-1 K+2 A+4
 5 | 1 |  14 |   48 |       12878 |    25 | C-2 F-3 B+3 D-1 E-1 C+3 A+1 D-3 A-1 C-3 B-3 C+3 F+3 A+4
 6 | 1 |   9 |   32 |        3229 |     6 | D+3 A-1 B-3 A+1 D-3 C-3 G-2 F+3 A+4
 7 | 1 |   9 |   28 |       17745 |    64 | B+1 D-3 I-3 C+2 J+1 K-1 H-1 F+3 A+4
 8 | 1 |   9 |   28 |       15385 |    62 | A-1 I-3 E+1 D-1 J-3 C+1 F+2 K+2 A+5
 9 | 1 |  14 |   36 |       32937 |   119 | D+1 E+1 G+1 F+2 H-1 A+1 B+3 A-1 H+1 F-3 E-1 G-1 H-1 A+4
10 | 1 |  12 |   35 |       11734 |    30 | B-3 G-2 E-2 H-1 I-2 A+3 J-1 M-2 C-1 K-1 F+3 A+2
11 | 1 |  12 |   30 |        2770 |     8 | A+1 F+1 K-3 C-1 E+2 A+1 B+1 G-1 H-1 I-1 D-2 A+3
12 | 1 |  17 |   50 |       29934 |    86 | A+2 H-1 F-1 C+2 G+4 A-2 B+1 E+1 K-2 C-3 F+1 H+1 I-4 D-1 L-1 F+2 A+4
13 | 1 |  25 |   82 |       26619 |    49 | E+3 A-1 F-2 C-1 G-3 C+1 D+1 F+3 A+1 E-3 C-3 H+1 B+3 H-1 C+3 E+3 A-1 F-4 A+1 E-3 C-3 D-3 G+2 H+3 A+4
14 | 1 |  17 |   51 |       11510 |    22 | F+2 H-1 C-2 G-3 C+2 D+3 H+3 A+1 B+1 F-3 G-1 A+2 H-3 C-1 D-1 E+3 A+2
15 | 1 |  16 |   49 |      115874 |   329 | E+2 F-1 D+1 I+1 A-3 E-2 J-3 C-2 D-2 H+3 M-1 F+3 G+2 E-1 J-1 A+5
16 | 1 |  17 |   52 |      101693 |   329 | E+1 I+1 A-2 G+1 B+3 G-1 A+2 E-3 I-3 A-2 L-2 K-2 C-4 D+1 J+1 K+1 A+5
17 | 1 |  23 |   56 |       13460 |    27 | B-1 C+1 G+1 N+1 M+1 L+1 A-2 D-1 I-1 J-2 F+1 K+1 E+2 D-2 I-2 A+2 C-1 L-1 M-2 N-2 F+1 K+1 A+3
18 | 1 |  21 |   63 |       61433 |   150 | D+1 E+2 I-2 K+1 A-3 H+1 G+1 K-3 J+2 D+1 C-2 H+3 C+2 D-1 J-2 K+3 A+3 K-3 C-1 F+3 A+2
19 | 1 |  24 |   72 |       58065 |   149 | D-2 F+2 G-1 J-2 K-2 C+3 L+3 E+2 A+1 I+1 B+4 A-1 G-1 I-1 E-4 A+1 I+1 B-2 C-3 D+1 J+1 L-3 K+2 A+4
20 | 1 |  25 |   86 |       48914 |    97 | C+2 D+3 E+3 I+1 A-1 G+4 A+1 B+1 H+1 I-3 C-3 F+2 B+3 H+3 F-2 C+3 I+3 A-1 G-4 A+1 I-3 C-3 D-3 F+3 A+4
21 | 1 |  22 |   67 |       16631 |    29 | D-2 A-2 B+1 F-1 G-1 C-1 E+2 H-2 B+3 A+2 H+2 D+4 A-2 F-2 H-2 B-4 A+2 H+2 D-2 E-2 C+1 A+3
22 | 1 |  10 |   29 |        7145 |    16 | H+1 G+2 E-2 I-2 C-1 D-3 H+1 I+1 J+1 A+5
23 | 1 |  21 |   71 |        8563 |    11 | C+2 G+2 A-1 F+4 A+1 B+1 G-3 C-3 E+1 B+3 E-1 C+3 G+3 A-1 F-4 A+1 G-3 C-3 D-3 E+3 A+4
24 | 1 |  26 |   73 |       55538 |   135 | D-1 G-1 A-1 J+1 B+3 A+1 G+1 F-3 K-1 I-1 L-2 C+2 B+1 E+1 I-2 J+1 K+2 H-3 K-2 L-2 I+3 B-1 E-1 C-3 K+3 A+4
25 | 1 |  29 |   79 |       31746 |    68 | C-2 E+1 I-1 J+1 F+1 B-1 A-3 B+1 F-1 J-1 I+1 E-1 C+3 H+1 B+1 G-3 B-1 E-2 I-4 J+1 F+1 B-1 H-2 C-1 D-4 E+2 H+1 J+2 A+5
26 | 1 |  26 |   77 |      183721 |   501 | C+1 F+1 E+2 D-1 H-1 A-2 B+1 G-1 I-2 J-2 C+2 F+2 B+3 A+2 D+2 H+4 A-2 D-2 G-2 B-4 A+2 D+2 H-2 F-2 J+1 A+3
27 | 1 |  27 |   80 |      196427 |   564 | H-1 F-1 I-1 C+2 K+1 A-1 G+4 A+1 B+1 E+1 K-3 C-3 J-3 C+3 K+3 A-1 B-1 E-1 G-4 C-2 L-2 I+2 M-1 F+3 H+1 J-1 A+5
28 | 1 |  28 |   78 |      117292 |   298 | E-1 I+1 J-1 C+1 K-1 H+3 A+1 B+1 F-3 E-1 L-1 K+2 B+3 A-1 K-2 H-4 A+1 C-1 J+1 K+3 B-3 D-1 I-1 C-3 D+1 K-2 L+3 A+3
29 | 1 |  28 |   86 |       56187 |   133 | J-2 I+1 F+2 G+2 H+2 E-2 A+1 B+4 A-1 E+2 G-3 H-3 E-1 F-2 I-4 E+1 F+2 H+3 E-2 A+1 I+1 B-3 I-1 D-1 C-3 F+1 J+3 A+4
30 | 1 |  30 |   82 |       28850 |    60 | B+1 F+3 K-1 L-1 J+2 D+2 E+1 H+1 I-3 B+1 G-1 L-1 C+1 K+2 G-3 B-1 K-2 I+3 E-1 H-1 D-2 J-1 K+3 F-3 B-1 A+3 K-2 C-1 L+2 A+2
31 | 1 |  24 |   72 |      186145 |   531 | F+1 G-1 I+1 J-2 C+3 D+2 H+1 E-1 B+3 A+1 E+1 H-4 A-1 E-1 B-3 C-3 D-2 J+2 I-2 G+2 K+3 F+2 B-1 A+5
32 | 1 |  32 |   88 |       29841 |    62 | C-1 D+2 E+1 H+1 I+1 F+3 A-1 B+1 J-1 C-2 E+1 G+3 E-1 C+1 J+1 B-1 A+3 F-3 H-1 I-1 B+4 A-2 H+1 F+1 J-3 C-1 E+1 G-4 D-1 E-1 C+3 A+4
33 | 1 |  37 |  107 |      132384 |   312 | B+1 E-2 A-1 C-2 D+3 C+2 A+1 E+4 A-1 B-1 C-3 I-3 C+3 G+1 H-1 K-1 D+1 G+1 A+3 C-3 I+1 E-3 I-1 C+3 B+1 E-1 A-3 C-2 G-1 D-4 C+2 G+1 A+3 C-1 J-1 K+2 A+2
34 | 1 |  37 |  100 |       24880 |    46 | G+1 H-1 K-3 D+1 J-1 C+4 E+1 I-1 F+3 J+1 D-1 K+1 H+1 G-1 A+3 F-3 I+1 E-3 I-1 F+3 B+1 E-1 A-3 F-1 G+1 H-1 K-1 D+1 J-1 C-4 F+1 J+1 D-1 K+3 H+1 G-1 A+5
35 | 1 |  40 |  118 |      118369 |   280 | G-1 K-3 I+1 J-3 C+1 L+1 E-1 I-2 H-3 C+2 D+3 I+2 F+3 G-1 H-1 J+2 A+3 B+1 G-2 F-3 E+1 L-3 E-1 F+3 G+2 B-1 L-1 A-3 F-2 J-1 D-4 F+2 J+1 A+3 F-1 C-3 J+1 I-1 K+3 A+2
36 | 1 |  43 |  115 |      170981 |   400 | A+1 B+1 F-3 G-1 H-1 J+1 E+1 K-1 C+3 B+2 A-1 I-3 L+1 B+1 C-3 E-2 D-3 E+2 C+1 G+1 K+1 F+3 I-1 A+1 B-4 A-1 D-1 I+1 F-1 K-1 C+2 L-1 I+3 A+1 B+1 C-3 E-1 F-2 G-1 H-1 J-1 K+3 A+4
37 | 1 |  43 |  119 |      193513 |   483 | D-3 J+1 H+1 C-1 K+1 B+1 G-1 I-2 E+3 I+2 G+1 B-1 K-1 C+3 H-1 J-1 F+3 A+1 H-3 A-1 F-3 C-3 K+1 B+1 G-1 I-2 E-4 I+2 G+1 B-1 K-1 C+3 F+3 A+1 H+1 B-3 D-1 G-1 A+2 F-3 C-1 K+3 A+2
38 | 1 |  44 |  109 |       77262 |   183 | A+1 E+1 H+1 L+1 F+1 K-1 B-1 C-1 L+2 I-3 L-1 C+1 B+1 K+1 F-1 L-2 E-1 J+4 E+1 L+1 F+1 K-1 B-1 C-1 L+2 G+3 I+3 A-2 H-2 L-1 C+1 B+1 K+1 F-1 L-2 E-3 D-1 J-1 C+2 L+1 F+1 K-1 E-1 A+4
39 | 1 |  47 |  113 |       49803 |   130 | J+1 C+1 A-1 G+1 H-2 F-1 K-1 L+2 G+2 A+1 C-1 E+1 J-1 G+1 L-2 F+1 H+1 B+1 C-2 L-1 I-3 L+1 C+1 B-1 H-1 F-1 L+2 G-1 J+1 C+2 A-1 E-1 G-2 D-2 L-2 F+1 H+1 G-1 A+1 C-1 J-1 M-2 F+2 K+3 H+1 I-1 A+4
40 | 1 |  48 |  126 |      104052 |   228 | F-1 K-2 I+1 H+1 G+2 E-1 D-1 C-3 J+1 H+2 I-1 K+1 F+1 E-1 A+1 B+3 A-1 E+1 F-1 K-1 I+1 H-1 C+3 B+1 D+1 E+1 G-3 E-1 H-2 I-4 E+1 H+1 G+3 K+1 F+1 E-2 A+1 I+1 B-4 A-1 I-1 D-2 C-1 J-4 D+1 H+1 K+2 A+5
41 | 1 |  50 |  133 |      195432 |   418 | C-1 K+2 L+2 H+2 B+1 F-1 C-1 I+1 G+3 I-1 C+1 F+1 B-1 A+3 B+1 F-1 C-1 I+1 E+2 D-4 J-4 E-2 I-1 C+1 F+1 B-1 A-3 B+1 F-1 C-1 I+1 G-3 I-1 C+1 F+1 B-1 H-2 K-4 H+1 B+1 F-1 C-1 I+1 L-3 G+3 I-1 C+3 F+1 B-1 A+5
42 | 1 |  51 |  133 |       99100 |   221 | K-1 M+1 I+1 C+3 D-1 H+2 L+1 F+3 B-1 E-1 A-3 E+1 G+1 B+3 E-1 A+2 F-3 H-3 A-1 L-1 D+1 C-3 K+1 B+1 I-4 A+1 C+2 H+3 A-1 I+1 B-1 J-1 K-1 C+1 D-1 L+1 F+3 A-1 E+1 B-3 E-1 A+1 F-1 G-1 I-1 L-1 D+1 C-1 M-1 K+3 A+4
---+---+-----+------+-------------+-------+---------
 0 | 1 |1035 | 2943 |     2678097 |  6980 |

