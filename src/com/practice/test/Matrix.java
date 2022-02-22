package com.practice.test;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class Matrix {

    /*
     * Complete the 'largestSubgrid' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY grid
     *  2. INTEGER maxSum
     */

    public static int largestSubgrid(List<List<Integer>> grid, int maxSum) {
        int last_Sum=0;
        int result =0;
        for(int k=1;k<= grid.size();k++){
            for(int i=0;i< grid.size() - k;i++){

                for(int j=0;j< grid.size() - k;j++){
                    result=  gridSum(grid,i,j,k);

                    if(last_Sum < result)
                        last_Sum=result;
                }
            }
        }

        return result;
    }

    private static int gridSum(List<List<Integer>> grid, int x, int y, int size){
        int sum=0;
        for(int i=0;i< size;i++){

            for(int j=0;j< size;j++){

                sum += grid.get(x + i).get(y + j);

            }
        }
        return sum;
    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        IntStream.range(0, gridRows).forEach(i -> {
            try {
                grid.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int maxSum = Integer.parseInt(bufferedReader.readLine().trim());

     //   int result = Result.largestSubgrid(grid, maxSum);

      //  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

