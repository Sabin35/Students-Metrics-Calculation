package markingMetrics.service;

import java.util.*;

public
class InputService {

    public static
    Map < String, List<Integer> > fetchInput ( ) {

        Scanner sc = new Scanner ( System.in );
        Map < String, List <Integer> > inputMap = new HashMap <> ( );
        boolean flag = true;

        System.out.println ( "======Please enter the input as asked below=========\n" );

//        This is an infinite loop that shall be exited only when the user wants to. i.e. give the "n" input.
        while (flag) {
            System.out.print ( "Please enter unit name: " );
            String unitName = sc.next ( );
            System.out.println ( );

            System.out.println ("Please enter the number of marks you'd like to enter for this course." );
            int repeatKey = sc.nextInt ();

            List<Integer> marksList = new ArrayList <> (  );

            for(int i = 0; i < repeatKey; i++){
                System.out.print ( "Please enter the marks 0-100: " );
                int marks = sc.nextInt ( );

//            This is a validation module that will validate the input marks.
                if ( marks < 0 || marks > 100 ) {

//                In case of validation is failed the user is displayed with an error message and asked to input the value again.
                    System.out.println ( "ERROR :: You have entered invalid marks available 0 - 100." );

                } else {

//                If the validation passes the data is stored and user is presented with a question if he
//                want to input more data into the data model.

                    marksList.add ( marks );

                    System.out.println ( "SUCCESS :: Data successfully added to the data model. " );

                }
            }

            inputMap.put ( unitName , marksList );

            System.out.println ( "======Would you like to add more values? (Y/N) ============" );
            String key = sc.next ( );

            flag = !key.equalsIgnoreCase ( "n" );
            System.out.println ( );

        }

        return inputMap;

    }
}
