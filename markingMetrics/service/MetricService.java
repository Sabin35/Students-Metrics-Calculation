package markingMetrics.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public
class MetricService {

    public static
    Map < String, String > getHighestLowestMetric ( Map < String, List < Integer > > dataModel ) {

        Map < String, String > resultMap = new HashMap <> ( );

        dataModel.forEach ( ( key , value ) -> {

            Integer max = Collections.max ( value );
            Collections.sort ( value );
            Integer min = value.get ( 0 );

            resultMap.put ( key , "HIGHEST: " + max + " || LOWEST: " + min );

        } );

        return resultMap;

    }


    public static
    double calculateMean ( List < Integer > dataList ) {

        AtomicReference < Integer > sum = new AtomicReference <> ( 0 );
        Integer size = dataList.size ( );

        dataList.forEach ( data -> {
            sum.updateAndGet ( v -> v + data );
        } );

        return sum.get ( ) / size;

    }

    public static
    double calculateStandardDeviation ( List<Integer> dataList ) {

        double mean = calculateMean ( dataList );

        AtomicReference < Double > standardDeviation = new AtomicReference <> ( 0.0 );

        dataList.forEach ( data->{
            standardDeviation.updateAndGet ( v -> v + Math.pow ( data - mean , 2 ) );
        } );

        return Math.sqrt ( standardDeviation.get() / dataList.size ( ) );

    }

}
