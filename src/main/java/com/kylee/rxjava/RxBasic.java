package com.kylee.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RxBasic {

    public static void main(String[] args) {
        //createObservable();
        //createEventHandler();
        //transMap();
        //transFlatMap();
        //transScan();
        transGroupBy();
    }

    public static class Shop {
        public int id;
        public String name;
        public List<Coordinate> coordinates = new ArrayList<>();

        @Override
        public String toString() {
            String str = id + " (" + name + ") [ ";
            for (Coordinate coordinate : coordinates) {
                str += (coordinate.toString() + " ");
            }
            str += "]";
            return str;
        }
    }

    public static class Coordinate {
        public String latitude;
        public String longitude;

        public Coordinate(String latitude, String longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "{" + latitude + ", " + longitude + "}";
        }
    }

    public static void transGroupBy2() {
        String[] cursor1row = {"1", "Foo", "lat1-1", "long1-1"};
        String[] cursor2row = {"1", "Foo", "lat1-2", "long1-2"};
        String[] cursor3row = {"2", "Bar", "lat2-1", "long2-1"};
        String[] cursor4row = {"1", "Foo", "lat1-3", "long1-3"};
        String[] cursor5row = {"1", "Foo", "lat1-4", "long1-4"};
        String[] cursor6row = {"3", "Ping", "lat3-1", "long3-1"};
        String[] cursor7row = {"2", "Bar", "lat2-2", "long2-2"};

        List<String[]> cursor = Arrays.asList(cursor1row, cursor2row, cursor3row, cursor4row, cursor5row, cursor6row, cursor7row);

//        Observable.fromIterable(cursor)
//                .groupBy(cursorRow -> cursorRow[0])
//                .flatMap(stringGroupedObservable ->
////                        groups ->
////                                groups.collect(
////                                        Shop::new,
////                                        (shop, rows) -> {
////                                            shop.id = Integer.parseInt(rows[0]);
////                                            shop.name = rows[1];
////                                            shop.coordinates.add(new Coordinate(rows[2], rows[3]));
////                                        }
////                                        )
//                )
//                .subscribe(shop -> System.out.println("RX" + shop.toString()));
    }

    public static void transGroupBy3() {
        final double[] averages = {0, 0};
        Observable<Integer> numbers = Observable.just(22, 22, 99, 22, 101, 22);
        Function<Integer, Integer> keySelector = integer -> integer % 2;
        Observable<GroupedObservable<Integer, Integer>> split = numbers.groupBy(keySelector);
        split.subscribe(
                group -> {
                    Observable<Double> convertToDouble = group.map(integer -> (double) integer);
                    Function<Double, Double> insertIntoAveragesArray = aDouble -> averages[group.getKey()] = aDouble;
                    convertToDouble.reduce((t1, t2) -> t1+t2).map(insertIntoAveragesArray).subscribe();

                }
        );
    }

    public static void transGroupBy() {
        int[] numbers = {1,2,3,4,7,8,9,10};
        final StringBuilder e = new StringBuilder();
        final StringBuilder o = new StringBuilder();
        Observable.fromArray(numbers)
                .groupBy((i) -> {
                    System.out.println(i[0]);
                    return 0 == (i[0]%2) ? "EVEN" : "ODD";
                })
                .subscribe(group ->
                        group.subscribe(number -> {
                            if(group.getKey().toString().equals("EVEN")) {
                                e.append(String.valueOf(number));
                            } else {
                                o.append(String.valueOf(number));
                            }
                        })
                );

        System.out.println(e);
        System.out.println(o);
    }

    public static void transScan() {
        String[] letters = {"a", "b", "c", "d"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(total -> System.out.println(total));
    }

    public static void createObservable() {
        Observable<String> observable = Observable.just("Hello");
        final StringBuilder result = new StringBuilder();
        observable.subscribe(s -> result.append(s));
        System.out.println(result);
    }

    public static void transFlatMap() {
        final StringBuilder r = new StringBuilder();
        Observable.just("book1", "book2")
                .flatMap(s -> Observable.just(s))
                .subscribe(l -> r.append(l));
        System.out.println(r);
    }

    public static void transMap() {
        Observable<String> ob = Observable.just("Hello");

        final StringBuilder r = new StringBuilder();
        ob.map(String::toUpperCase)
                .subscribe(letter -> r.append(letter));
        System.out.println(r);
    }

    public static void createEventHandler() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};

        Observable<String> ob = Observable.fromArray(letters);
        final StringBuilder result = new StringBuilder();
        ob.subscribe(
                i -> result.append(i),
                Throwable::printStackTrace,
                () -> result.append("_Completed")
        );

        System.out.println(result);
    }

}
