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
package org.mxpersonal.AntiSwearAPI;

import java.util.ArrayList;
import java.util.Random;
import org.mxpersonal.AntiSwearAPI.Api.KNearestNeighborClassifier;
import org.mxpersonal.AntiSwearAPI.Api.QuickSort;

// This class is only for testing
public class Main {
  public static void main(String[] args) {
    // Euc distance
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(3);
    test.add(2);
    test.add(5);
    test.add(1);
    test.add(0);
    ArrayList<Integer> train = new ArrayList<Integer>();
    train.add(2);
    train.add(2);
    train.add(3);
    train.add(0);
    train.add(3);
    KNearestNeighborClassifier knn = new KNearestNeighborClassifier();
    double result = knn.eucDistance(train, test);
    System.out.println("Euc test: " + result);

    // Quick Sort
    Random rnd = new Random();
    int arr[] = new int[10];
    for (int i = 0; i < 10; i++) {
      arr[i] = rnd.nextInt(100);
    }
    System.out.print("un-sorted array: ");
    QuickSort.printArray(arr);
    int n = arr.length;

    QuickSort ob = new QuickSort();
    ob.sort(arr, 0, n - 1);

    System.out.print("sorted array: ");
    QuickSort.printArray(arr);
  }
}
