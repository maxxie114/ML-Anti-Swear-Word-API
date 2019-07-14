# Data Conversion Module
These module will contains python scripts that convert normal word list 
to csv data that can be easily read by the algorithms

# Training Data Format
The converted training data is a CSV file that contains 1738 lines of data, and here is the format:
- First, the first 26 columns are occurence of all 26 alphabets (a-z) in that word
- The 27 column is the length of the word
- The 28 column is whether the word is a bad word or not, if it is, then the number is 1, else it would be 0
