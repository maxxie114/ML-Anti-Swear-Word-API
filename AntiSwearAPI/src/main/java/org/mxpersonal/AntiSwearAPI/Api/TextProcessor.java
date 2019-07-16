/**
 * MIT License
 *
 * Copyright (c) 2019 maxxie114
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.mxpersonal.AntiSwearAPI.Api;

import java.util.ArrayList;

public class TextProcessor {

  /* 
   * TODO 
   * 1. implement convert() that convert words to data
   * 2. implement split that split sentences into words
   * 3. implement convertAll() that convert each words in the
   * sentence into data, and return an arraylist of array
   */

  /**
   * This function convert an English word to data array
   * 
   * @param  word  the word that need to be converted
   * @return       The int array that contains all the data      
   */
  public int[] convert(String word) {
    int[] a = new int[5];
    return a;
  }

  /**
   * This function split a sentence into words
   * 
   * @param  sentence  The sentence that need to be split
   * @return           An array of words
   */
  public String[] split(String sentence) {
    String[] result = null;
    return result;
  }

  /**
   * This function convert every words in an array to data.
   * 
   * @param  arrOfWords  A string array of words 
   * @return             An Arraylist of arrays
   */
  public ArrayList<Integer> convertAll(String[] arrOfWords) {
    return null;
  }


}
