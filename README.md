# Template-Design-Pattern


Both the 1D Discrete Fourier Transform and the 1D Discrete
Cosine Transform do the same thing. Given a finite sequence of numbers, they expressthem us a sum of basis functions;
their difference being that DFT uses complex
exponentials and DCT uses real-valued cosine functions. They are both very powerful
transformations with numerous actual applications; such as jpeg compression, antenna
technologies, etc.
TL; DR: given an array of numbers of length N, DFT and DCT both produce a new array of
numbers also of length N. DFT produces complex numbers, DCT produces real numbers.
There is an abundance of online resources on both of them, explaining their calculation
step by step.
https://en.wikipedia.org/wiki/Discrete_Fourier_transform
https://en.wikipedia.org/wiki/Discrete_cosine_transform – DCT II
Both transforms follow pretty much the same main procedure:
a) Read N tab separated numbers from a file provided as a command line argument
b) Transform the numbers into N outputs (DFT or DCT outputs..)
c) Write the N outputs to a new file
d) only in the case of DFT, sometimes the user wants additionally the time of
execution printed on screen; by default NO.
Implement both 1D transforms, and make sure that you apply the Template Method design
pattern. Don’t forget to draw the UML diagram and pay attention to hooks.
