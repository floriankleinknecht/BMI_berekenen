This java program calculates the Body Mass Index (BMI) of adult users by answering four questions.

The program consists of a single class. It starts with a while loop and each question is wrapped in an inner while loop. This ensures that the question is repeated (using a continue statement) if the user fills in a wrong input. The inner while loops break when the user fills in a correct input. The outer while loop ensures that the user can shut down the program at any moment by filling in “X” at one of the questions.

Some often occurring errors in the input, like using comma’s in decimals or the use of centimetres instead of meters at the length question, are automatically corrected.

After answering the four questions, the program returns the calculated BMI of the user and a reference table.
