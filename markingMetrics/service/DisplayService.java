package markingMetrics.service;

import java.util.List;
import java.util.Map;

public
class DisplayService {

    public static
    void displayDataSet ( Map < String, List < Integer > > dataModel ) {

        System.out.println ( "=================== Data Model ===================" );
        System.out.println ( "==== unit name ====            ====== Marks ======" );

        dataModel.forEach ( ( key , value ) -> {
            StringBuilder marksData = new StringBuilder ( );
            value.forEach ( data -> {
                marksData.append ( " | " ).append ( data );
            } );
            System.out.println ( key + " ".repeat ( 25 ) + marksData );
        } );
    }

    public static
    void displayHighestAndLowestMark ( Map < String, List < Integer > > dataModel ) {

        System.out.println ( "=================== Marks Metrics ===================" );
        System.out.println ( "===============  Highest and Lowest =================" );

        Map < String, String > resultData = MetricService.getHighestLowestMetric ( dataModel );

        resultData.forEach ( ( key , value ) -> {
            System.out.println ( "Unit Name: " + key + " " + value );
        } );

    }

    public static
    void displayMean ( Map < String, List < Integer > > dataModel ) {

        System.out.println ( "=================== Marks Metrics ===================" );
        System.out.println ( "================= Mean calculation  =================" );

        dataModel.forEach ( ( key , value ) -> {

            System.out.println ( "Unit name : " + key + " || Mean: " + MetricService.calculateMean ( value ) );

        } );
    }

    public static
    void displayStandardDeviation ( Map < String, List<Integer> > dataModel ) {

        System.out.println ( "=================== Marks Metrics ===================" );
        System.out.println ( "======== Standard Deviation calculation  ============" );

        dataModel.forEach ( (key,value)->{

        System.out.println ( "Unit name: "+key+" || SD: " + MetricService.calculateStandardDeviation ( value ) );

        } );

    }
}
