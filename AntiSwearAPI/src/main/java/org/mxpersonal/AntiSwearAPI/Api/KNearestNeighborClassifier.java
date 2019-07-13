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
import java.util.Random;

public class KNearestNeighborClassifier {

  private ArrayList<Integer> trainingData;
  private Random rnd;

  /**
   * This function take in a 2D Arraylist of all training data
   * 
   * @param trainData
   */
  public void fit(ArrayList trainData) {
    this.trainingData = trainData;
  }

  /**
   * This function calculate the euclidean distance of two points in an n dimension graph
   * 
   * @param trainFeature
   * @param testFeature
   * @return int distance    The distance of two point
   */
  public int eucDistance(ArrayList trainFeature, ArrayList testFeature) {
    //TODO Using the euclidean distance algorithm to calculate the distance
    return 0;
  }

  /**
   * This function uses KNearestNeighbor algorithm to predict the result of the guess
   * 
   * @param testData
   * @return int result    This number can be 1 or 0
   */
  public int predict(ArrayList testData) {
    //TODO Implement kNN algorithm
    return 0;
  }

}
