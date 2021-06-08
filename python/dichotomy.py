import sys

from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = sympify(str_expr)
f = lambdify(x, expr, 'numpy')

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
    print('          a                b                x                fx')
    while b - a > Accuracy:
        times = times + 1
        c = (a + b) / 2
        fa = f(a)
        fb = f(b)
        fc = f(c)
        print('%d  %.6f  %.6f  %.6f  %.6f' % (times, a, b, c, fc))
        if abs(fc) < 1e-9:
            break
        elif fc * fa < 0:
            b = c
        elif fc * fb < 0:
            a = c
x = c
print(round(x, 9))
print(times)
