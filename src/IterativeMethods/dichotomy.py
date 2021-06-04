import sys
import time

from numpy import *
from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = sympify(str_expr)
f = lambdify(x, expr, 'numpy')
derivation = diff(expr, x)
df = lambdify(x, derivation, 'numpy')

a = float(sys.argv[2])
b = float(sys.argv[3])
Accuracy = float(sys.argv[4])
c = 0.0
times = -1

fa = f(a)
fb = f(b)
if fa * fb > 0:
    print('a,b error')
else:
    while b - a > Accuracy:
        c = (a + b) / 2
        fa = f(a)
        fb = f(b)
        fc = f(c)
        if abs(fc) < 1e-9:
            times = times + 1
            x = c
            print(times, c)
            break
        elif fc * fa < 0:
            b = c
        elif fc * fb < 0:
            a = c
        times = times + 1


