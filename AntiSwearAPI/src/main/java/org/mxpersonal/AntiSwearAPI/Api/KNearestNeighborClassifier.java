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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class KNearestNeighborClassifier {

  private ArrayList<int[]> trainingData;
  private Random rnd;

  /**
   * This function take in a 2D Arraylist of all training data
   * 
   * @param trainData
   */
  public void fit(ArrayList trainData) {
    this.trainingData = trainData;
  }

  //  /**
  //   * This function calculate the euclidean distance of two points in an n dimension graph
  //   * 
  //   * @param trainFeature
  //   * @param testFeature
  //   * @return int distance    The distance of two point
  //   */
  //  public double eucDistance(ArrayList<Integer> trainFeature, ArrayList<Integer> testFeature) {
  //    /* 
  //     * euclidean distance formula:
  //     * 
  //     * distance = sqrt((a2-a1)^2 + (b2-b1)^2 + ... + (n2-n1)^2)
  //     */
  //    double sum = 0;
  //    for (int i = 0; i < trainFeature.size(); i++) {
  //      double operation = Math.pow((trainFeature.get(i) - testFeature.get(i)), 2);
  //      sum = sum + operation;
  //    }
  //    double finalDistance = Math.sqrt(sum);
  //    return finalDistance;
  //  }

  /**
   * This function calculate the euclidean distance of two points in an n dimension graph
   * 
   * @param trainFeature
   * @param testFeature
   * @return int distance    The distance of two point
   */
  public double eucDistance(int[] trainFeature, int[] testFeature) {
    /* 
     * euclidean distance formula:
     * 
     * distance = sqrt((a2-a1)^2 + (b2-b1)^2 + ... + (n2-n1)^2)
     */
    double sum = 0;
    for (int i = 0; i < trainFeature.length; i++) {
      double operation = Math.pow((trainFeature[i] - testFeature[i]), 2);
      sum = sum + operation;
    }
    double finalDistance = Math.sqrt(sum);
    return finalDistance;
  }

  /**
   * This function uses KNearestNeighbor algorithm to predict the result of the guess
   * 
   * @param testData
   * @return int result    This number can be 1 or 0
   */
  public int predict(int[] testData) {
    /*
     * kNN algorithm:
     * 
     * This algorithm compare the distance of every training data to the test data using 
     * the euclidean distance algorithm, and find a specfic amount of training data 
     * that are closest to the test data (the value of k determine that amount). 
     * 
     * After that, the algorithm compare those data, and determine whether more of those
     * data are labeled with 0, or 1. And use that to give the guess
     * 
     * To determine k: sqrt(amount of training data)
     */

    /*
     * Problem:
     * Since results and distances will be stored in different arrays, but in the same order,
     * sorting distances will mess up the label, which mess up the predictions
     * 
     * Solution:
     * Instead of sorting distances, use a search algorithm, search for the smallest distance, and then
     * the second smallest number, and so on. Get the index of that number, use the index to 
     * find the result, and store it in a new ArrayList for evaluation
     */

    // Step 1 : Determine k    
    double k = Math.sqrt(this.trainingData.size());

    // Step 2: Calculate distances
    // Create an ArrayList to hold all the distances calculated
    ArrayList<Double> distances = new ArrayList<Double>();
    // Create another ArrayList to store the results
    ArrayList<Integer> results = new ArrayList<Integer>();
    for (int[] i : this.trainingData) {
      // Create a temp array with the last item (result) eliminated
      int[] temp = Arrays.copyOf(i, i.length - 1);
      double distance = this.eucDistance(temp, testData);
      // Add both the result and the distance into associated arraylists
      results.add(i[i.length - 1]);
      distances.add(distance);
    }

    // Step 3: Search for the amount of highest points according to k
    ArrayList<Integer> closestResultLst = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) {
      double smallestDistance = Collections.min(distances);
      int indexOfSmallestDistance = distances.indexOf(smallestDistance);
      int resultOfSmallestDistance = results.get(indexOfSmallestDistance);
      closestResultLst.add(resultOfSmallestDistance);
      // Set the smallest distance to null, so it won't be searched again
      distances.set(indexOfSmallestDistance, null);
    }

    // Step 4: Determine which one should be the result by looking at the majority of the numbers
    int yes = 0, no = 0;
    for (int i : closestResultLst) {
      if (i == 1) {
        yes++;
      } else if (i == 0) {
        no++;
      }
    }

    // Step 5: Return the result
    if (yes > no) {
      return 1;
    } else {
      return 0;
    }
  }
}
