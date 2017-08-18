#  This code was inspired by the following tutorial:
#  https://matplotlib.org/users/pyplot_tutorial.html

import numpy as np
import matplotlib.pyplot as plt

#  Measured run-time of the python program. 10 runs:
py_stats   = [0, 32, 33, 10, 33, 54, 28, 32, 34, 35, 33]

#  Measured run-time of the JAVA program. 10 runs:
java_stats = [0, 18, 14, 10, 13, 11, 31, 9, 9, 10, 8]

plt.figure(1)				#  The figure itself
plt.plot(py_stats)			#  The plot (line) of the python statistics
plt.plot(java_stats)			#  The plot (line) of the JAVA statistics
plt.xlabel('Run number')		#  X axis label
plt.ylabel('Time in milliseconds')	#  Y axis label
plt.xticks(np.arange(0,11,1))		#  Set ticks of the X axis (Start from 0, 11 units, one tick per unit)
plt.yticks(np.arange(0,60,5))		#  Set ticks of the Y axis (Start from 0, 60 units, one tick per 5 units)
plt.title('Runtime statistics of python and JAVA. Blue = python, Orange = JAVA')	#  Title of the figure

plt.show()
