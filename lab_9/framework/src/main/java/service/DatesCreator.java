package service;

import model.Date;

public class DatesCreator {
    public static final String TESTDATA_DEPART_DATE = "testdata.date.depart";
    public static final String TESTDATA_RETURN_DATE = "testdata.date.return";

    public static Date datesFromProperty(){
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE),
                TestDataReader.getTestData(TESTDATA_RETURN_DATE));
    }
}
