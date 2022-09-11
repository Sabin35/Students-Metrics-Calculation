package markingMetrics.main;

import markingMetrics.service.DisplayService;
import markingMetrics.service.InputService;

import java.util.List;
import java.util.Map;

public
class Main {
    public static
    void main ( String[] args ) {

        System.out.println ("========WELCOME TO THE MARKING METRICS APPLICATION========" );

        Map<String, List <Integer> > dataModel = InputService.fetchInput ( );

        System.out.println ( );

        DisplayService.displayDataSet ( dataModel );

        System.out.println ( );
        DisplayService.displayHighestAndLowestMark ( dataModel );

        System.out.println ( );
        DisplayService.displayMean ( dataModel );

        System.out.println ( );
        DisplayService.displayStandardDeviation ( dataModel );

        System.out.println ( );
        System.out.println ("===THANK YOU FOR USING THE MARKING METRICS APPLICAITON===" );
    }
}
