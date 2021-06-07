import sys

from sympy import *
from sympy.abc import x, y

str_expr = sys.argv[1]
expr = sympify(str_expr)
f = lambdify(x, expr, 'numpy')
derivation = diff(expr, x)
df = lambdify(x, derivation, 'numpy')

x0 = float(sys.argv[2])
Accuracy = float(sys.argv[3])
c = 0.0
times = 0

preX = x0
error = 10000
print('          x                f(x)')
while error > Accuracy:
    print('%d  %.6f  %.6f' % (times, preX, x0))
    fx = f(preX)
    dfx = df(preX)
    x0 = preX - fx/dfx
    preError = error
    error = abs(x0 - preX)
    if error > preError:
        print('error')
        break
    times = times + 1
    preX = x0
print(round(x0, 9))
print(times)
