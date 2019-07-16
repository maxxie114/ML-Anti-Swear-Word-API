# Copyright 2019 Max Xie

# Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
# and associated documentation files (the "Software"), to deal in the Software without restriction,
# including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
# and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
# subject to the following conditions:

# The above copyright notice and this permission notice shall be included in all copies or substantial 
# portions of the Software.

# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT 
# NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
# WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
# OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


# Import modules
import random
import logging
import csv

# Logging
# logging.basicConfig(filename='result.log', filemode='a', format='%(asctime)s - %(message)s', datefmt='%d-%b-%y %H:%M:%S', level=logging.DEBUG)
logging.getLogger().addHandler(logging.StreamHandler())

# Functions
def convert(word, isBadword):
    """ This function will convert a word to 28 different feature elements, they are:
        How many of each letter does the word contains (26 elements)
        What is the length of the word (1 element)
        Is badword or is not badword (1 element) 

        this function get a string as an input, and the result(1 or 0), and return a list
    
    """
    # generate all 26 alphabet and store them into a list
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    occurences = []

    for i in range(26):
        singleLetterOccurences = 1
        for j in word:
            if j == alphabet[i]:
                singleLetterOccurences += 1
        occurences.append(singleLetterOccurences)
    
    occurences.append(len(word))
    occurences.append(int(isBadword))

    return occurences
            


# Main
def main():
    """This is the main method"""
    # Declear variables
    word_list = open("trainingWordList.txt")
    csv_reader = csv.reader(word_list, delimiter=',')
    line_count = 0
    # wordlist = [x for x in csv.reader(word_list)]
    wordlist = [x for x in csv.reader(word_list)]
    result = []
    for i in range(len(wordlist)):
        word = wordlist[i][0]
        isBadWord = wordlist[i][1]
        print([x for x in convert(word,isBadWord)])
        result.append([x for x in convert(word,isBadWord)])
    with open("convertedTrainingData.csv", "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerows(result)


# Run the main method
main()
