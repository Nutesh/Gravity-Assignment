package org.gravity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Nutesh Rathod
 */
public class BOGOService {

    private static final String DISCOUNT = "discountedItems";
    private static final String PAYABLE = "payableItems";
    public static void main(String[] args) {
        List<Integer> productPrice = Arrays.asList(10,20,30,40,50,50,60);
        Map<String,List<Integer>> payables = findPayables(productPrice);
        System.out.println(payables);
    }

    private static Map<String, List<Integer>> findPayables(List<Integer> productPrice) {
        Map<String,List<Integer>> payables = new HashMap<>();
        Collections.sort(productPrice,Collections.reverseOrder());
        List<Integer> payableItems = IntStream.range(0, productPrice.size())
                .filter(n -> n % 2 == 0)
                .mapToObj(productPrice::get)
                .collect(Collectors.toList());
        List<Integer> discountedItems = IntStream.range(0, productPrice.size())
                .filter(n -> n % 2 == 1)
                .mapToObj(productPrice::get)
                .collect(Collectors.toList());
        payables.put(DISCOUNT,discountedItems);
        payables.put(PAYABLE,payableItems);
        return payables;
    }
}